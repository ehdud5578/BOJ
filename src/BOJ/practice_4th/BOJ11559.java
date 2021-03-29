package BOJ.practice_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11559 {
    static int h, w, result;
    static int[][] board;
    static int[] dy, dx;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        h = 12;
        w = 6;
        result = 0;

        board = new int[h][w];
        visited = new boolean[h][w];
        dy = new int[]{0, 1, 0, -1};
        dx = new int[]{1, 0, -1, 0};
        for (int i = 0; i < h; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                String tmp1 = temp[j];
                if (tmp1.equals(".")) board[i][j] = 0;
                else if (tmp1.equals("R")) board[i][j] = 1;
                else if (tmp1.equals("G")) board[i][j] = 2;
                else if (tmp1.equals("B")) board[i][j] = 3;
                else if (tmp1.equals("P")) board[i][j] = 4;
                else board[i][j] = 5;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> deleteq = new ArrayList<>();
        while (true) {
            boolean iscal = false;
            for(int i = 0;i<h;i++){
                Arrays.fill(visited[i],false);
            }
            for (int i = h - 1; i >= 0; i--) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] != 0 && !visited[i][j]) {
                        deleteq.clear();
                        queue.add(new int[]{i, j});
                        deleteq.add(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] point = queue.poll();
                            int thiscolor = board[point[0]][point[1]];
                            visited[point[0]][point[1]] = true;
                            for (int k = 0; k < 4; k++) {
                                int ny = point[0] + dy[k];
                                int nx = point[1] + dx[k];
                                if (ny >= 0 && ny < h && nx >= 0 && nx < w) {
                                    if (board[ny][nx] == thiscolor && !visited[ny][nx]) {
                                        visited[ny][nx] = true;
                                        queue.add(new int[]{ny, nx});
                                        deleteq.add(new int[]{ny, nx});
                                    }
                                }
                            }
                        }
                        if (deleteq.size() >= 4) {
                            for (int[] d : deleteq) {
                                board[d[0]][d[1]] = 0;
                            }
                            iscal = true;
                        }
                    }

                }
            }
            for (int i = h - 1; i > 0; i--) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == 0) {
                        int z = i;
                        while (true) {
                            z--;
                            if (board[z][j] != 0 || z == 0) {
                                board[i][j] = board[z][j];
                                board[z][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
            if(iscal)
                result++;
            else
                break;
        }
        System.out.println(result);
    }
}
