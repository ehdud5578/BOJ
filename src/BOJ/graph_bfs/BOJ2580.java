package BOJ.graph_bfs;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2580 {
    static int[][] board;
    static boolean che;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        che = false;
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        ch(0, 0);
        bw.flush();
    }

    public static void ch(int dy, int dx) throws IOException {
        if (dy == 9 && dx == 0) {
            che = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(board[i][j] + " ");
                }
                bw.write("\n");
            }
            return;
        }
        if (board[dy][dx] == 0) {
            for (int k = 1; k < 10; k++) {
                board[dy][dx] = k;
                if (check(dy, dx)) {
                    if (dx < 8)
                        ch(dy, dx + 1);
                    else
                        ch(dy + 1, 0);
                }
                if(che)
                    break;
            }
            board[dy][dx] = 0;
        } else {
            if (dx < 8)
                ch(dy, dx + 1);
            else
                ch(dy + 1, 0);
        }
    }

    public static boolean check(int dy, int dx) {
        boolean[] ch = new boolean[10];
        boolean[] wch = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[dy][i] == 0)
                continue;
            if (ch[board[dy][i]])
                return false;
            if (!ch[board[dy][i]]) {
                ch[board[dy][i]] = true;
            }
        }
        for(int i = 0;i<9;i++){
            if (board[i][dx] == 0)
                continue;
            if (wch[board[i][dx]])
                return false;
            if (!wch[board[i][dx]]) {
                wch[board[i][dx]] = true;
            }
        }
        ch = new boolean[10];
        int ny = dy / 3 * 3;
        int nx = dx / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[ny + i][nx + j] == 0)
                    continue;
                if (ch[board[ny + i][nx + j]])
                    return false;
                if (!ch[board[ny + i][nx + j]]) {
                    ch[board[ny + i][nx + j]] = true;
                }
            }
        }
        return true;
    }
}
