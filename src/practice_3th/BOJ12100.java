package practice_3th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12100 {
    static int n;
    static int[][] board;
    static int[] dy,dx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dy = new int[]{0,1,0,-1};
        dx = new int[]{1,0,-1,0};
        for(int i = 0;i<n;i++){
            StringTokenizer stz = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        for(int i = 0;i<4;i++){
            dfs(i,0);
        }
    }
    public static void dfs(int dir,int deep){// dir 0~3 동 남 서 북
        if(deep==5){
            return;
        }


        for(int i = 0;i<4;i++){
            dfs(i,deep+1);
        }
    }
}
