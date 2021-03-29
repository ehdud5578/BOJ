package BOJ.practice_4th;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] board = new int[100001][2];
        int[] result = new int[100001];
        boolean[] visited = new boolean[100001];
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        for(int j = 0;j<=100000;j++){
            Arrays.fill(board[j],-1);
        }
        visited[n] = true;
        board[n][0] = 0;
        int i = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == k)
                break;
            if (now - 1 >= 0 && !visited[now - 1]) {
                visited[now - 1] = true;
                board[now - 1][0] = board[now][0] + 1;
                board[now - 1][1] = now;
                q.add(now - 1);
            }
            if (now + 1 < 100001 && !visited[now + 1]) {
                visited[now + 1] = true;
                board[now + 1][0] = board[now][0] + 1;
                board[now + 1][1] = now;
                q.add(now + 1);
            }
            if (now > 1 && now * 2 < 100001 && !visited[now * 2]) {
                visited[now * 2] = true;
                board[now * 2][0] = board[now][0] + 1;
                board[now * 2][1] = now;
                q.add(now * 2);
            }
        }
        bw.write(board[k][0] + "\n");
        result[i] = k;
        i ++;
        while (board[k][1] != -1) {
            result[i] = board[k][1];
            k = board[k][1];
            i++;
        }
        for (int j = i-1; j >= 0; j--) {
            bw.write(result[j] + " ");
        }
        bw.flush();
    }
}
