package graph_bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        boolean[] board = new boolean[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        board[n] = true;
        int time = 0;
        qq:
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0;i<size;i++){
                int next = q.poll();
            }
            time++;
        }
        bw.write(String.valueOf(time));
        bw.flush();
    }
}
