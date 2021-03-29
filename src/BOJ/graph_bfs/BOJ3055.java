package BOJ.graph_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ3055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        String[][] board = new String[n][m];
        int startx = 0, starty = 0, distx = 0, disty = 0, time = 0,result = -1;
        int[] dx, dy;
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};
        boolean[][] visited = new boolean[n][m];
        ArrayList<int[]> water = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] temp1 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = temp1[j];
                if (board[i][j].equals("S")) {
                    starty = i;
                    startx = j;
                } else if (board[i][j].equals("D")) {
                    disty = i;
                    distx = j;
                } else if (board[i][j].equals("*")) {
                    water.add(new int[]{i, j});
                } else if (board[i][j].equals("X")) {
                    visited[i][j] = true;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < water.size(); i++) {
            int[] a = water.get(i);
            q.add(new int[]{a[0], a[1], 1});
            visited[a[0]][a[1]] = true;
        }
        q.add(new int[]{starty, startx, 2});
        visited[starty][startx] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] now = q.poll();
                if (now[0] == disty && now[1] == distx) {
                    if (now[2] == 2) {
                        result = time;
                    }
                    break;
                }
                for (int k = 0; k < 4; k++) {
                    int ny = now[0] + dy[k];
                    int nx = now[1] + dx[k];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (!visited[ny][nx]) {
                            if (now[2] == 1) {
                                if (board[ny][nx].equals("D")) {
                                    continue;
                                }
                            }
                            visited[ny][nx] = true;
                            q.add(new int[]{ny,nx,now[2]});
                        }
                    }
                }
            }
            time++;
        }
        if(result==-1){
            System.out.println("KAKTUS");
        }
        else{
            System.out.println(result);
        }

    }
}
