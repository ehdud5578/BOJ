package BOJ.graph_bfs;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1707 {
    static int k, v, e;
    static ArrayList<Integer>[] board;
    static int result;
    static int[] value;
    public static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            result = 0;
            String[] temp = br.readLine().split(" ");
            v = Integer.parseInt(temp[0]);
            e = Integer.parseInt(temp[1]);
            board = new ArrayList[v+1];
            for (int k = 0; k <= v; k++) {
                board[k] = new ArrayList<Integer>();
            }
            for (int k = 0; k < e; k++) {
                temp = br.readLine().split(" ");
                int v1 = Integer.parseInt(temp[0]);
                int v2 = Integer.parseInt(temp[1]);
                board[v2].add(v1);
                board[v1].add(v2);
            }
            bfs();
        }
        bw.flush();
        br.close();
        bw.close();
    }
    public static void bfs(){
        value = new int[v+1];
        queue = new LinkedList<>();
        for(int i = 1;i<=v;i++){
            if(value[i]==0) {
                queue.add(i);
                value[i] = 1;
            }
            while(!queue.isEmpty()){
                int now = queue.poll();
                for(int j = 0;j<board[now].size();j++){
                    if(value[board[now].get(j)]==0){
                        queue.add(board[now].get(j));
                    }
                    if(value[board[now].get(j)]==value[now]){
                        System.out.println("NO");
                        return;
                    }
                    if(value[now]==1&&value[board[now].get(j)]==0){
                        value[board[now].get(j)] = 2;
                    }
                    else if ((value[now]==2&&value[board[now].get(j)]==0)){
                        value[board[now].get(j)] = 1;
                    }
                }
            }
        }
        System.out.println("YES");
    }
}
