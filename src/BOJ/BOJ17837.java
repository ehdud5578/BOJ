package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17837 {
    static int n, k;
    static int[][] board;
    static Horse[] horses;
    static int[] dy, dx; //0,→, ←, ↑, ↓

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        dy = new int[]{0, 0, 0, -1, 1};
        dx = new int[]{0, 1, -1, 0, 0};
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {     //0은 흰색, 1은 빨간색, 2는 파란색
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        horses = new Horse[k + 1];
        for (int i = 1; i <= k; i++) {
            stz = new StringTokenizer(br.readLine());
            horses[i] = new Horse(Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken()));

        }
        for (int i = 1; i <= 1000; i++) {
            for(int j = 1;j<=k;j++){

            }
        }
    }
}

class Horse {
    public Horse(int y, int x, int dir) {
        this.y = y;
        this.x = x;
        this.dir = dir;
    }

    int y;
    int x;
    int dir;

}