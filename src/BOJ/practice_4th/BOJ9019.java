package BOJ.practice_4th;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9019 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        int[] result = new int[10001];
        int[][] board = new int[10001][3];
        for(int i = 0;i<testcase;i++){
            for(int k = 0;k<=10000;k++){
                Arrays.fill(board[k],-1);
            }
            Arrays.fill(result,0);
            int cnt = 0;
            StringTokenizer stz = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(stz.nextToken());
            int v2 = Integer.parseInt(stz.nextToken());
            board[v1][0] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(v1);
            while (!q.isEmpty()){
                int now = q.poll();
                if(now==v2)
                    break;
                if(board[now*2%10000][0]==-1){
                    board[now*2%10000][0] = board[now][0] +1;
                    board[now*2%10000][1] = now;
                    board[now*2%10000][2] = 1;
                    q.add(now*2%10000);
                }
                if(board[(now-1+10000)%10000][0]==-1){
                    board[(now-1+10000)%10000][0] = board[now][0] +1;
                    board[(now-1+10000)%10000][1] = now;
                    board[(now-1+10000)%10000][2] = 2;
                    q.add((now-1+10000)%10000);
                }
                int x1 = now%10;
                int x2 = (now/10)%10;
                int x3 = (now/100)%10;
                int x4 = (now/1000)%10;
                int r = x1*1000 + x4*100+ x3*10 + x2;
                int l = x3*1000 + x2*100 + x1*10 + x4;
                if(board[l][0]==-1){
                    board[l][0] = board[now][0] + 1;
                    board[l][1] = now;
                    board[l][2] = 3;
                    q.add(l);
                }
                if(board[r][0]==-1){
                    board[r][0] = board[now][0] + 1;
                    board[r][1] = now;
                    board[r][2] = 4;
                    q.add(r);
                }
            }
            while(true){
                result[cnt] = board[v2][2];
                v2 = board[v2][1];
                if(board[v2][2]==-1)
                    break;
                cnt++;
            }
            for(int rcnt = cnt;rcnt>=0;rcnt--){
                if(result[rcnt]==1){
                    bw.write("D");
                }
                else if(result[rcnt]==2){
                    bw.write("S");
                }
                else if(result[rcnt]==3){
                    bw.write("L");
                }
                if(result[rcnt]==4){
                    bw.write("R");
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
