package BOJ.graph_bfs;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1261 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(stz.nextToken());
        int n = Integer.parseInt(stz.nextToken());
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        boolean[][] board = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(temp[j]) == 1;
            }
        }
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        qq:
        while (true) {
            while (!queue.isEmpty()) {
                int[] now = queue.pollFirst();
                if(now[0]==n-1&&now[1]==m-1) {
                    bw.write(String.valueOf(now[2]));
                    break qq;
                }
                for (int i = 0; i < 4; i++) {
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    int dist = now[2];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (!visited[ny][nx] && !board[ny][nx]) {
                            visited[ny][nx] = true;
                            queue.addFirst(new int[]{ny, nx, dist});
                        } else if (!visited[ny][nx] && board[ny][nx]) {
                            visited[ny][nx] = true;
                            queue.addLast(new int[]{ny, nx, dist + 1});
                        }
                    }
                }
            }
        }
        bw.flush();
    }
}
