package BOJ.practice_3th;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ3190 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, applecnt, commandcnt, direction,time;
    static int[][] board;
    static int[][] command;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        direction = 1;
        applecnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < applecnt; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(stz.nextToken())-1;
            int x = Integer.parseInt(stz.nextToken())-1;
            board[x][y] = 1;
        }
        commandcnt = Integer.parseInt(br.readLine());
        command = new int[commandcnt+1][2];
        command[commandcnt][0] = 100;
        for (int i = 0; i < commandcnt; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            command[i][0] = Integer.parseInt(stz.nextToken());
            String str = stz.nextToken();
            if (str.equals("D")) {
                command[i][1] = -1;
            } else
                command[i][1] = 1;
        }
        Deque<Point> q = new LinkedList<>();
        q.addFirst(new Point(0, 0));
        board[0][0] = 2;
        qq:while (true) {
            for(int i = 0;i<=commandcnt;i++){
                int cnt = command[i][0]-time;
                for(int j = 0;j<cnt;j++){
                    time++;
                    Point locnow = q.peekFirst();
                    int ny = locnow.y + dy[direction];
                    int nx = locnow.x + dx[direction];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                        if (board[ny][nx] == 0) {
                            board[ny][nx] = 2;
                            q.addFirst(new Point(nx, ny));
                            Point tail = q.pollLast();
                            board[tail.y][tail.x] = 0;
                        }
                        else if (board[ny][nx] == 1) {
                            board[ny][nx] = 2;
                            q.addFirst(new Point(nx, ny));
                        }
                        else if(board[ny][nx] == 2){
                            break qq;
                        }
                    } else
                        break qq;

                }
                direction = (direction + command[i][1]+4)%4;
            }
        }
        bw.write(time+"\n");
        bw.flush();
    }
}
