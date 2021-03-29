package BOJ.practice_5th;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17142 {
    static int n, m, result, cntzero;
    static int[][] board;
    static int[] dx, dy;
    static ArrayList<int[]> q;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        q = new ArrayList<>();
        board = new int[n][n];
        result = 987654321;
        cntzero = 0;
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
                if (board[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (board[i][j] == 0)
                    cntzero++;
            }
        }
        visited = new boolean[q.size()];
        dfs(0, 0);
        if (result == 987654321)
            bw.write("-1");
        else
            bw.write(result + "\n");
        bw.flush();
    }

    public static void dfs(int k, int v) {
        if (v == m) {
            bfs();
            return;
        }
        for (int i = k; i < q.size(); i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            dfs(i + 1, v + 1);
            visited[i] = false;
        }
    }

    public static void bfs() {
        int zeros = cntzero;
        int[][] clone = new int[n][n];
        boolean[][] cvisited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < q.size(); i++) {
            if (visited[i])
                queue.add(q.get(i));
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, clone[i], 0, n);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            if (zeros == 0)
                break;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] now = queue.poll();
                cvisited[now[0]][now[1]] = true;
                for (int i = 0; i < 4; i++) {
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < n&&!cvisited[ny][nx]) {
                        if (clone[ny][nx] == 0) {
                            cvisited[ny][nx] = true;
                            clone[ny][nx] = 2;
                            queue.add(new int[]{ny, nx});
                            zeros--;
                        } else if (clone[ny][nx] == 2){
                            cvisited[ny][nx] = true;
                            queue.add(new int[]{ny, nx});
                        }
                    }
                }
            }
            time++;
        }
        if (zeros == 0)
            result = Math.min(time, result);
    }
}
