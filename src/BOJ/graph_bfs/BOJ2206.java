package BOJ.graph_bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
    static int n,m;
    static int[][] board;
    static int[] dx,dy;
    static boolean[][][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        dx = new int[]{1,0,-1,0};
        dy = new int[]{0,1,0,-1};
        int result = Integer.MAX_VALUE;
        board = new int[n][m];
        visited = new boolean[n][m][2];
        for(int i = 0;i<n;i++){
            String[] temp = br.readLine().split("");
            for(int j = 0;j<m;j++){
                board[i][j] = Integer.parseInt(temp[j]);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1,0});
        visited[0][0][0] = true;
        qq:
        while (!q.isEmpty()){
            int[] now = q.poll();
            if(now[0]==n-1&&now[1]==m-1){
                result = Math.min(result,now[2]);
                break qq;
            }
            for(int k = 0;k<4;k++){
                int ny = now[0] +dy[k];
                int nx = now[1] +dx[k];
                int dist = now[2] +1;
                int chone = now[3];
                if(ny>=0&&ny<n&&nx>=0&&nx<m){
                    if(!visited[ny][nx][chone]&&board[ny][nx]==0){
                        visited[ny][nx][chone] = true;
                        q.add(new int[]{ny,nx,dist,chone});
                    }
                    else if(!visited[ny][nx][chone]&&board[ny][nx]==1&&chone==0){
                        visited[ny][nx][chone] = true;
                        q.add(new int[]{ny,nx,dist,chone+1});
                    }
                }
            }
        }
        if(result==Integer.MAX_VALUE){
            bw.write("-1\n");
        }
        else
            bw.write(result+"\n");
        bw.flush();
    }
}
