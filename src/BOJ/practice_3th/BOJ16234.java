package BOJ.practice_3th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {
    static int n,l,r,result;
    static int[][] board;
    static int[] dy,dx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz =  new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        l = Integer.parseInt(stz.nextToken());
        r = Integer.parseInt(stz.nextToken());
        dy = new int[]{0,1,0,-1};
        dx = new int[]{1,0,-1,0};
        result = 0;
        board = new int[n][n];
        for(int i = 0;i<n;i++){
            stz = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        bfs();
        System.out.println(result);
    }
    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        qq:while(true){
            boolean[][] visited = new boolean[n][n];
            ArrayList<int[]> list = new ArrayList<>();
            int sum;
            int checktime = 0;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(!visited[i][j]){
                        list.clear();
                        q.add(new int[]{i,j});
                        visited[i][j] = true;
                        list.add(new int[]{i,j});
                        sum =0;
                        sum += board[i][j];
                        while (!q.isEmpty()){
                            int[] now = q.poll();
                            int thisy = now[0];
                            int thisx = now[1];
                            for(int k = 0;k<4;k++){
                                int ny = thisy +dy[k];
                                int nx = thisx +dx[k];
                                if(ny>=0&&ny<n&&nx>=0&&nx<n){
                                    if(!visited[ny][nx]&&Math.abs(board[thisy][thisx]-board[ny][nx])>=l&&Math.abs(board[thisy][thisx]-board[ny][nx])<=r){
                                        q.add(new int[]{ny,nx});
                                        visited[ny][nx] = true;
                                        list.add(new int[]{ny,nx});
                                        sum += board[ny][nx];
                                        checktime++;
                                    }
                                }
                            }
                            if(q.isEmpty()){
                                int value = sum/list.size();
                                for(int e = 0;e<list.size();e++){
                                    int[] thise = list.get(e);
                                    board[thise[0]][thise[1]] = value;
                                }
                            }
                        }
                    }
                }
            }

            if(checktime==0)
                break;
            else
                result++;
        }

    }
}
