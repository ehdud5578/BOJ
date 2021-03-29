package BOJ.practice_3th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15684 {
    static int n,m,h,result;
    static boolean[][] board,boardch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        h = Integer.parseInt(stz.nextToken());
        board = new boolean[h+1][n+1];
        boardch = new boolean[h+1][n+1];
        result = 10;
        for(int i = 1;i<=m;i++){
            stz = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(stz.nextToken());
            int j = Integer.parseInt(stz.nextToken());
            board[k][j] = true;
        }
        search(0,1,1);
        if(result>=4)
            System.out.println("-1");
        else
            System.out.println(result);
    }
    public static void chechvalue(int v){
        if(v<=3){
            int[] rcheck = new int[n+1];
            for(int i =1;i<=n;i++){
                rcheck[i] = i;
            }
            for(int i = 1;i<=h;i++){
                for(int j = 1;j<n;j++){
                    if(board[i][j]){
                        int temp = rcheck[j];
                        rcheck[j] = rcheck[j+1];
                        rcheck[j+1] = temp;
                    }
                }
            }
            boolean resultch = true;
            for(int i = 1;i<=n;i++){
                if(i!=rcheck[i])
                    resultch = false;
            }
            if(resultch){
                result = Math.min(result,v);
            }
        }

    }
    public static void search(int v,int ry,int rx){
        if(v<=3) chechvalue(v);
        else return;
        for(int i = ry;i<=h;i++){
            for(int j = 1;j<n;j++){
                if(boardch[i][j]||board[i][j])
                    continue;
                if(board[i][j-1]||board[i][j+1])
                    continue;
                boardch[i][j] = true;
                board[i][j] = true;
                search(v+1,i,j);
                boardch[i][j] = false;
                board[i][j] = false;
            }
        }
    }
}
