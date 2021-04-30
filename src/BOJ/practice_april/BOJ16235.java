package BOJ.practice_april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16235 {
    static int n,m,k;
    static int[][] board,seed,deadtree;
    static PriorityQueue<Tree> tree,treebreeding;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        board = new int[n][n];
        seed = new int[n][n];
        deadtree = new int[n][n];
        tree = new PriorityQueue<>();
        treebreeding = new PriorityQueue<>();
        for(int i = 0;i<n;i++){
            Arrays.fill(board[i],5);
        }
        for(int i = 0;i<n;i++){
            stz = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                seed[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        for(int i = 0;i<m;i++){
            stz = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stz.nextToken())-1;
            int y1 = Integer.parseInt(stz.nextToken())-1;
            int age1 = Integer.parseInt(stz.nextToken());
            tree.add(new Tree(1,age1,y1,x1));
        }
        int thisyear = 0;
        qq:
        while (true){
            thisyear++;
            while (!tree.isEmpty()){
                if(tree.peek().year>thisyear)
                    break;
                Tree tree1 = tree.poll();
                if (board[tree1.y][tree1.x] >= tree1.age) {
                    board[tree1.y][tree1.x] -= tree1.age;
                    tree1.age = tree1.age + 1;
                    if(tree1.age%5==0){
                        treebreeding.add(new Tree(tree1.year+1, tree1.age, tree1.y, tree1.x));
                    }
                    tree.add(new Tree(tree1.year+1, tree1.age, tree1.y, tree1.x));
                } else {
                    deadtree[tree1.y][tree1.x] += tree1.age;
                }
            }
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    board[i][j] += deadtree[i][j]/2;
                    deadtree[i][j] = 0;
                }
            }
            while(!treebreeding.isEmpty()){
                Tree tree2 = treebreeding.poll();
                for(int y1 = -1;y1<2;y1++){
                    for(int x1 = -1;x1<2;x1++){
                        if(y1==0&&x1==0)
                            continue;
                        int ny = tree2.y + y1;
                        int nx = tree2.x + x1;
                        if(ny<n&&ny>=0&&nx<n&&n>=0){
                            tree.add(new Tree(tree2.year,1,ny,nx));
                        }
                    }
                }
            }
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    board[i][j]+=seed[i][j];
                }
            }
            if(thisyear>=k){
                break;
            }
        }
        int result = 0;
        while(!tree.isEmpty()){
            tree.poll();
            result++;
        }
        while (!treebreeding.isEmpty()){
            treebreeding.poll();
            result++;
        }
        System.out.println(result);
    }
}
class Tree implements Comparable<Tree>{
    int year;
    int age;
    int y;
    int x;

    public Tree(int year, int age, int y, int x) {
        this.year = year;
        this.age = age;
        this.y = y;
        this.x = x;
    }

    @Override
    public int compareTo(Tree o) {
        if(this.year==o.year)
            return o.age - this.age;
        else
            return this.year - o.year;
    }

}