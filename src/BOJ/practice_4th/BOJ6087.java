package BOJ.practice_4th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6087 {
    static int w, h, time;
    static int[][] board;
    static int[] dy, dx;
    static ArrayList<int[]> laser = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        w = Integer.parseInt(stz.nextToken());
        h = Integer.parseInt(stz.nextToken());
        board = new int[h][w];
        dy = new int[]{0, 1, 0, -1};
        dx = new int[]{1, 0, -1, 0};
        time = 0;
        for (int i = 0; i < h; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                String temp1 = temp[j];
                if (temp1.equals(".")) {// 빈공간
                    board[i][j] = Integer.MAX_VALUE;
                } else if (temp1.equals("*")) { // 벽
                    board[i][j] = -1;
                } else {                  // laser
                    board[i][j] = Integer.MAX_VALUE;
                    laser.add(new int[]{i, j});
                }
            }
        }
        int[] destination = laser.get(1);
        int desty = destination[0];
        int destx = destination[1];
        Queue<int[]> q = new LinkedList<>();
        q.add(laser.get(0));
        qq:while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                board[point[0]][point[1]] = time;
                for(int k = 0;k<4;k++){
                    int ny = point[0] + dy[k];
                    int nx = point[1] + dx[k];
                    while (true) {
                        if (ny >= 0 && ny < h && nx >= 0 && nx < w && board[ny][nx]>=time) {
                            if(ny==desty&&nx==destx)
                                break qq;
                            if(board[ny][nx]==Integer.MAX_VALUE){
                                board[ny][nx] = time;
                                q.add(new int[]{ny, nx});
                            }
                            ny = ny + dy[k];
                            nx = nx + dx[k];
                        } else
                            break;
                    }
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
