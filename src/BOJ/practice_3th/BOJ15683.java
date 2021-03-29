package BOJ.practice_3th;

import java.io.*;
import java.util.*;

public class BOJ15683 {
    static int n, m, cntzero = 0, result;
    static int[][] board;
    static ArrayList<int[]> cctvlist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] direction = {
            {1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1},
            {1, 0, 1, 0}, {0, 1, 0, 1},
            {1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}, {1, 0, 0, 1},
            {1, 1, 1, 0}, {1, 1, 0, 1}, {1, 0, 1, 1}, {0, 1, 1, 1},
            {1, 1, 1, 1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        board = new int[n][m];
        cctvlist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
                if (board[i][j] == 0)
                    cntzero++;
                if (board[i][j] < 6 && board[i][j] > 0) {
                    cctvlist.add(new int[]{i, j, board[i][j]});
                }
            }
        }
        result = cntzero;
        bfs();
        bw.write(result + "\n");
        bw.flush();
    }

    public static cctv cal(int[][] call, int dir, int y, int x, int num) {
        int[][] nextboard = new int[n][m];
        for (int i = 0; i < call.length; i++) {
            System.arraycopy(call[i], 0, nextboard[i], 0, m);
        }
        for (int i = 0; i < 4; i++) {
            if (direction[dir][i] == 0)
                continue;
            int nx = x, ny = y;
            while (true) {
                ny = ny + dy[i];
                nx = nx + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (nextboard[ny][nx] == 6)
                        break;
                    if (nextboard[ny][nx] == 0){
                        nextboard[ny][nx] = 8;
                        num--;
                    }
                } else
                    break;
            }
        }
        if(result>num) result = num;
        return new cctv(nextboard, num);
    }

    public static void bfs() {
        Queue<cctv> queue = new LinkedList<>();
        queue.add(new cctv(board, cntzero));
        for (int[] ints : cctvlist) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                cctv thiscctv = queue.poll();
                switch (ints[2]) {
                    case 1:
                        queue.add(cal(thiscctv.cctv, 0, ints[0], ints[1], thiscctv.num));
                        queue.add(cal(thiscctv.cctv, 1, ints[0], ints[1], thiscctv.num));
                        queue.add(cal(thiscctv.cctv, 2, ints[0], ints[1], thiscctv.num));
                        queue.add(cal(thiscctv.cctv, 3, ints[0], ints[1], thiscctv.num));
                        break;
                    case 2:
                        queue.add(cal(thiscctv.cctv, 4, ints[0], ints[1], thiscctv.num));
                        queue.add(cal(thiscctv.cctv, 5, ints[0], ints[1], thiscctv.num));
                        break;
                    case 3:
                        queue.add(cal(thiscctv.cctv, 6, ints[0], ints[1], thiscctv.num));
                        queue.add(cal(thiscctv.cctv, 7, ints[0], ints[1], thiscctv.num));
                        queue.add(cal(thiscctv.cctv, 8, ints[0], ints[1], thiscctv.num));
                        queue.add(cal(thiscctv.cctv, 9, ints[0], ints[1], thiscctv.num));
                        break;
                    case 4:
                        queue.add(cal(thiscctv.cctv, 10, ints[0], ints[1], thiscctv.num));
                        queue.add(cal(thiscctv.cctv, 11, ints[0], ints[1], thiscctv.num));
                        queue.add(cal(thiscctv.cctv, 12, ints[0], ints[1], thiscctv.num));
                        queue.add(cal(thiscctv.cctv, 13, ints[0], ints[1], thiscctv.num));

                        break;
                    case 5:
                        queue.add(cal(thiscctv.cctv, 14, ints[0], ints[1], thiscctv.num));
                        break;
                }
            }
        }

    }
}

class cctv {
    public cctv(int[][] cctv, int num) {
        this.cctv = cctv;
        this.num = num;
    }

    int[][] cctv;
    int num;

}
