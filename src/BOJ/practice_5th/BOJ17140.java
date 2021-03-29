package BOJ.practice_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;

    @Override
    public int compareTo(Point o) {
        if (o.y == this.y) return o.x > this.x ? -1 : 1;
        else {
            return o.y > this.y ? -1 : 1;
        }
    }
}

public class BOJ17140 {
    static int r, c, k, row, col, result, nrow, ncol;
    static int[][] board;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        r = Integer.parseInt(stz.nextToken()) - 1;
        c = Integer.parseInt(stz.nextToken()) - 1;
        k = Integer.parseInt(stz.nextToken());
        row = 3;
        col = 3;
        cnt = new int[101];
        board = new int[101][101];
        for (int i = 0; i < 3; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        result = -1;
        PriorityQueue<Point> queue = new PriorityQueue<>();
        for (int i = 0; i <= 100; i++) {
            if (board[r][c] == k) {
                result = i;
                break;
            } else {
                if (row >= col) {
                    ncol = 0;
                    for (int k = 0; k < row; k++) {
                        Arrays.fill(cnt, 0);
                        for (int j = 0; j < col; j++) {
                            cnt[board[k][j]]++;
                        }
                        Arrays.fill(board[k], 0);
                        for (int j = 1; j <= 100; j++) {
                            if (cnt[j] != 0) {
                                queue.offer(new Point(j, cnt[j]));
                            }
                        }
                        int size = 0;
                        while (!queue.isEmpty()) {
                            Point now = queue.poll();
                            board[k][size] = now.x;
                            board[k][size + 1] = now.y;
                            size += 2;
                            if (size == 100) {
                                queue.clear();
                                break;
                            }
                        }
                        ncol = Math.max(ncol, size);
                    }
                    col = ncol;
                } else {
                    nrow = 0;
                    for (int k = 0; k < col; k++) {
                        Arrays.fill(cnt, 0);
                        for (int j = 0; j < row; j++) {
                            cnt[board[j][k]]++;
                            board[j][k] = 0;
                        }
                        for (int j = 1; j <= 100; j++) {
                            if (cnt[j] != 0) {
                                queue.offer(new Point(j, cnt[j]));
                            }
                        }
                        int size = 0;
                        while (!queue.isEmpty()) {
                            Point now = queue.poll();
                            board[size][k] = now.x;
                            board[size + 1][k] = now.y;
                            size += 2;
                            if(size==100){
                                queue.clear();
                                break;
                            }
                        }
                        nrow = Math.max(nrow, size);
                    }
                    row = nrow;
                }
            }
        }
        System.out.println(result);
    }
}
