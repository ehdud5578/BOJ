package BOJ.graph_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589 {
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(stz.nextToken());
        int w = Integer.parseInt(stz.nextToken());
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{1, 0, -1, 0};
        board = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                if (temp[j].equals("L")) {
                    board[i][j] = true;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j]) {
                    boolean[][] visited = new boolean[h][w];
                    int tempresult = 0;
                    visited[i][j] = true;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j, tempresult});
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int ny = now[0] + dy[k];
                            int nx = now[1] + dx[k];
                            int nresult = now[2] + 1;
                            if (ny >= 0 && ny < h && nx >= 0 && nx < w) {
                                if (board[ny][nx] && !visited[ny][nx]) {
                                    visited[ny][nx] = true;
                                    q.add(new int[]{ny, nx, nresult});
                                    result = Math.max(result, nresult);
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
