package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA2117 {
    static int testcase, result, n, m;
    static boolean[][] check, board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        testcase = Integer.parseInt(br.readLine());
        for (int x = 1; x <= testcase; x++) {
            result = 0;
            StringTokenizer stz = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stz.nextToken());
            m = Integer.parseInt(stz.nextToken());
            board = new boolean[n][n];
            check = new boolean[n][n];
            for (int y1 = 0; y1 < n; y1++) {
                stz = new StringTokenizer(br.readLine());
                for (int x1 = 0; x1 < n; x1++) {
                    board[y1][x1] = Integer.parseInt(stz.nextToken()) == 1;
                }
            }
            for (int y1 = 0; y1 < n; y1++) {
                for (int x1 = 0; x1 < n; x1++) {
                    for (int k = 1; k < n + 2; k++) {
                        int homecnt = 0;
                        int cost = k * k + (k - 1) * (k - 1);
                        for (int y2 = 0; y2 < n; y2++) {
                            for (int x2 = 0; x2 < n; x2++) {
                                check[y2][x2] = (Math.abs(y1 - y2) + Math.abs(x1 - x2)) < k;
                            }
                        }
                        for (int y2 = 0; y2 < n; y2++) {
                            for (int x2 = 0; x2 < n; x2++) {
                                if (check[y2][x2] && board[y2][x2])
                                    homecnt++;
                            }
                        }
                        if (cost <= homecnt * m)
                            result = Math.max(result, homecnt);
                    }
                }
            }
            bw.write("#" + x + " " + result + "\n");
        }
        bw.flush();
    }
}
