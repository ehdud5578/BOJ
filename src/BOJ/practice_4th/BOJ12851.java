package BOJ.practice_4th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        int[][] board = new int[100001][2];
        for (int i = 0; i < 100001; i++) {
            board[i][0] = Integer.MAX_VALUE;
            board[i][1] = 0;
        }
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        board[n][0] = 0;
        board[n][1] = 1;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        q.add(n);
        boolean isresult = true;
        int time = 0;
        while (!q.isEmpty() && isresult) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                if (now == k)
                    isresult = false;
                if (now - 1 >= 0 && board[now - 1][0] >= time) {
                    board[now - 1][0] = time;
                    board[now - 1][1] = board[now - 1][1] + board[now][1];
                    hashSet.add(now - 1);
                }
                if (now + 1 <= 100000 && board[now + 1][0] >= time) {
                    board[now + 1][0] = time;
                    board[now + 1][1] = board[now + 1][1] + board[now][1];
                    hashSet.add(now + 1);
                }
                if (now >= 1 && now * 2 <= 100000 && board[now * 2][0] >= time) {
                    board[now * 2][0] = time;
                    board[now * 2][1] = board[now * 2][1] + board[now][1];
                    hashSet.add(now * 2);
                }
            }
            q.addAll(hashSet);
            hashSet.clear();
        }
        System.out.println(board[k][0]);
        System.out.println(board[k][1]);
    }
}
