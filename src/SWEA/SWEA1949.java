package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1949 {
    static int testcase, h, w, result, maxvalue;
    static int[][] board;
    static int[] dy, dx;
    static ArrayList<int[]> maxlist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        testcase = Integer.parseInt(br.readLine());
        dy = new int[]{0, 1, 0, -1};
        dx = new int[]{1, 0, -1, 0};
        for (int x = 1; x <= testcase; x++) {
            maxlist = new ArrayList<>();
            maxvalue = 0;
            result = 0;
            StringTokenizer stz = new StringTokenizer(br.readLine());
            h = Integer.parseInt(stz.nextToken());
            w = Integer.parseInt(stz.nextToken());
            board = new int[h][h];
            for (int i = 0; i < h; i++) {
                stz = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) {
                    board[i][j] = Integer.parseInt(stz.nextToken());
                    maxvalue = Math.max(maxvalue, board[i][j]);
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < h; j++) {
                    if (board[i][j] == maxvalue)
                        maxlist.add(new int[]{i, j});
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < h; j++) {
                    for (int k = 0; k <= w; k++) {
                        board[i][j] = board[i][j] - k;
                        for (int[] ints : maxlist)
                            dfs(1, ints);
                        board[i][j] = board[i][j] + k;
                    }
                }
            }
            bw.write("#" + x + " " + result + "\n");
            maxlist.clear();
        }
        bw.flush();
    }

    public static void dfs(int v, int[] max) {
        if (v > result)
            result = v;
        int thisvalue = board[max[0]][max[1]];
        for (int i = 0; i < 4; i++) {
            int ny = max[0] + dy[i];
            int nx = max[1] + dx[i];
            if (ny >= 0 && ny < h && nx >= 0 && nx < h) {
                if (thisvalue > board[ny][nx]) {
                    dfs(v + 1, new int[]{ny, nx});
                }
            }
        }
    }
}
