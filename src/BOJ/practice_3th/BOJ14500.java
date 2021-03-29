package BOJ.practice_3th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {
    static int n, m, result;
    static int[][] board;
    static int[] dy, dx;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        dy = new int[]{0, 1, 0, -1, 1, 1, -1, -1};
        dx = new int[]{1, 0, -1, 0, -1, 1, -1, 1};
        result = 0;
        board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visited[i][j] = false;
                int sum_temp = 0;
                if (i + 1 < n && j + 2 < m) { //ㅜ
                    sum_temp = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i + 1][j + 1];
                    result = Math.max(result, sum_temp);
                }
                if (i + 2 < n && j + 1 < m) {//ㅏ
                    sum_temp = board[i][j] + board[i + 1][j] + board[i + 1][j + 1] + board[i + 2][j];
                    result = Math.max(result, sum_temp);
                }
                if (i >= 1 && j + 2 < m) {//ㅗ
                    sum_temp = board[i][j] + board[i][j + 1] + board[i - 1][j + 1] + board[i][j + 2];
                    result = Math.max(result, sum_temp);
                }
                if (i >= 1 && i + 1 < n && j + 1 < m) {//ㅓ
                    sum_temp = board[i][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i - 1][j + 1];
                    result = Math.max(result, sum_temp);
                }
            }
        }
        System.out.println(result);
    }

    public static void dfs(int y, int x, int deep, int sum) {
        if (deep == 4) {
            result = Math.max(result, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dfs(ny, nx, deep + 1, sum + board[ny][nx]);
                    visited[ny][nx] = false;
                }
            }
        }
    }
}
