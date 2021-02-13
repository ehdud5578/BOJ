package SWEA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class SWEA2105 {
    static int testtime, n, result = 0;
    static int[][] board;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        testtime = Integer.parseInt(br.readLine());
        check = new boolean[101];

        for (int i = 1; i <= testtime; i++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            result = 0;
            for (int k = 0; k < n; k++) {
                StringTokenizer stz = new StringTokenizer(br.readLine());
                for (int kx = 0; kx < n; kx++) {
                    board[k][kx] = Integer.parseInt(stz.nextToken());
                }
            }
            find();
            if (result == 0)
                bw.write("#" + i + " " + "-1\n");
            else
                bw.write("#" + i + " " + result + "\n");
        }
        bw.flush();
    }

    public static void find() {
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                for (int x1 = 1; x1 <= i; x1++) {
                    for (int y1 = 1; y1 < n; y1++) {
                        if (i + y1 < n && i - x1 >= 0 && j + x1 + y1 < n) {
                            Arrays.fill(check, false);
                            sum(i, j, x1, y1);
                        }
                    }
                }
            }
        }
    }

    public static void sum(int i, int j, int x1, int y1) {
        int thiscasesum = 0;
        for (int ky = 0; ky < x1; ky++) {
            if (!check[board[i - ky][j + ky]]) {
                check[board[i - ky][j + ky]] = true;
                thiscasesum++;
            } else
                return;
        }
        for (int ky = 0; ky < x1; ky++) {
            if (!check[board[i + y1 - ky][j + y1 + ky]]) {
                check[board[i + y1 - ky][j + y1 + ky]] = true;
                thiscasesum++;
            } else
                return;
        }
        for (int kx = 0; kx <= y1; kx++) {
            if (!check[board[i - x1 + kx][j + x1 + kx]]) {
                check[board[i - x1 + kx][j + x1 + kx]] = true;
                thiscasesum++;
            } else
                return;
        }
        for (int kx = 1; kx < y1; kx++) {
            if (!check[board[i + kx][j + kx]]) {
                check[board[i + kx][j + kx]] = true;
                thiscasesum++;
            } else
                return;
        }
        result = Math.max(result, thiscasesum);
    }
}
