package BOJ.graph_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ4963 {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy, dx;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        dx = new int[]{1, 0, -1, 0, 1, 1, -1, -1};// 동 남 서 북
        dy = new int[]{0, 1, 0, -1, -1, 1, 1, -1};// 동 남 서 북

        while (true) {
            int cnt = 0;
            String[] temp = br.readLine().split(" ");
            int w = Integer.parseInt(temp[0]);
            int h = Integer.parseInt(temp[1]);

            if (w == 0 && h == 0)
                break;
            board = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                temp = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(temp[j]);
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        visited[i][j] = true;
                        queue.add(new int[]{i, j});
                    }
                    while (!queue.isEmpty()) {
                        int[] tempxy = queue.poll();
                        for (int k = 0; k < 8; k++) {
                            int nexty = tempxy[0] + dy[k];
                            int nextx = tempxy[1] + dx[k];
                            if (nexty >= 0 && nexty < h && nextx >= 0 && nextx < w) {
                                if (board[nexty][nextx] == 1 && !visited[nexty][nextx]) {
                                    queue.add(new int[]{nexty, nextx});
                                    visited[nexty][nextx] = true;
                                }
                            }
                        }
                    }

                }
            }
            System.out.println(cnt);
        }

    }
}