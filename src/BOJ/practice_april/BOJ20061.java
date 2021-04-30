package BOJ.practice_april;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20061 {
    static boolean[][] board;
    static int n, t, x, y,point;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new boolean[10][10];// 오른쪽 블루 아래 초록
        n = Integer.parseInt(br.readLine());
        point = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            t = Integer.parseInt(stz.nextToken());
            x = Integer.parseInt(stz.nextToken());
            y = Integer.parseInt(stz.nextToken());
            blocklocate(t, y, x);
            check();

        }
    }
    public static void check(){
        for(int i = 9;i>5;i--){
            boolean ispoint = true;
            for(int j = 0;j<4;j++){
                if(!board[i][j])
                    ispoint = false;
            }
            if(ispoint) {
                point++;
                board[i][4]= true;
            }
        }
        for(int i = 9;i>5;i--){
            if(board[i][4]){
                for(int k = 0;k<4;k++){

                }
            }
        }
        for(int i = 9;i>5;i--){
            boolean ispoint = true;
            for(int j = 0;j<4;j++){
                if(!board[j][i])
                    ispoint = false;
            }
            if(ispoint) {
                point++;
                board[4][i] = true;
            }
        }
    }
    public static void blocklocate(int t, int y, int x) {
        // t = 1
        if (t == 1) {
            int nexty = y;
            int nextx = x;
            while (y < n - 1) {
                if (!board[nexty + 1][x]) {
                    nexty = nexty + 1;
                }
            }
            while (y < n - 1) {
                if (!board[y][nextx + 1]) {
                    nextx = nextx + 1;
                }
            }
            board[nexty][x] = true;
            board[y][nextx] = true;
        }
        // t = 2
        else if (t == 2) {
            int y2 = y + 1;
            while (y2 < n - 1) {
                if (!board[y2+1][x]) {
                    y2 = y2 + 1;
                }
            }
            board[y2][x] = board[y2 - 1][x] = true;
            int x1 = x;
            while(x1<n-1){
                if(!board[y][x1+1]&&!board[y+1][x1+1]){
                    x1 = x1+1;
                }
            }
            board[y][x1] = board[y+1][x1] = true;
        }
        // t = 3
        else {
            int x1 = x+1;
            while(x1<n-1){
                if(!board[y][x1+1]){
                    x1 = x1+1;
                }
            }
            board[y][x1] = board[y][x1-1] = true;
            int y1 = y;
            while(y1<n-1){
                if(!board[y1+1][x]&&!board[y1+1][x+1]){
                    y1 = y1+1;
                }
            }
            board[y1][x] = board[y1][x+1] = true;
        }
    }
}
