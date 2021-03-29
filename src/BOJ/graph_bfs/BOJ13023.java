package BOJ.graph_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ13023 {
    static boolean[] visited;
    static int result, n, m;
    static ArrayList<Integer>[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        board = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            board[i] = new ArrayList();
        }
        visited = new boolean[n];
        result = 0;
        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int v1 = Integer.parseInt(temp[0]);
            int v2 = Integer.parseInt(temp[1]);
            board[v1].add(v2);
            board[v2].add(v1);
        }
        for (int i = 0; i < n; i++) {
            if (result == 0)
                dfs(i, 1);
        }
        System.out.println(result);
    }

    public static void dfs(int thisi, int v) {
        if (v == 5) {
            result = 1;
            return;
        }
        visited[thisi] = true;
        for (int j : board[thisi]) {
            if (!visited[j]) {
                visited[j] = true;
                dfs(j, v + 1);
                visited[j] = false;
            }
        }
        visited[thisi] = false;
    }
}
