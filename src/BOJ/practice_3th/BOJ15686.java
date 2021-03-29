package BOJ.practice_3th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15686 {
    static int n,m,result;
    static int[][] board;
    static ArrayList<int[]> chicken,home;
    static boolean[] checkm;
    static int[] dy,dx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        result =Integer.MAX_VALUE;
        board = new int[n][n];
        dy = new int[]{0,1,0,-1};
        dx = new int[]{1,0,-1,0};
        for(int i = 0;i<n;i++){
            stz = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                int x = Integer.parseInt(stz.nextToken());
                if(x==0){
                    board[i][j] = x;
                }
                else if(x==1){
                    home.add(new int[]{i,j});
                    board[i][j] = 1;
                }
                else{
                    chicken.add(new int[]{i,j});
                    board[i][j] = 0;
                }
            }
        }
        checkm = new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(result);
    }
    public static void dfs(int start, int v){
        if(v==m){
            int thiscaseresult = 0;
            for (int[] ints : home) {
                Queue<int[]> q = new LinkedList<>();
                boolean[][] visited = new boolean[n][n];
                q.add(ints);
                qq:
                while (!q.isEmpty()) {
                    int[] now = q.poll();
                    visited[now[0]][now[1]] = true;
                    for (int k = 0; k < 4; k++) {
                        int ny = now[0] + dy[k];
                        int nx = now[1] + dx[k];
                        if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                            if (!visited[ny][nx]) {
                                if (board[ny][nx] == 2) {
                                    int tempresult = Math.abs(ints[0] - ny) + Math.abs(ints[1] - nx);
                                    thiscaseresult = thiscaseresult + tempresult;
                                    break qq;
                                }
                                if (board[ny][nx] == 0||board[ny][nx] == 1) {
                                    visited[ny][nx] = true;
                                    q.add(new int[]{ny, nx});
                                }
                            }
                        }
                    }
                }
            }
            result = Math.min(result,thiscaseresult);
            return;
        }
        for(int i = start;i< chicken.size();i++){
            if(checkm[i])
                continue;
            checkm[i] = true;
            int[] now = chicken.get(i);
            board[now[0]][now[1]] = 2;
            dfs(i,v+1);
            board[now[0]][now[1]] = 0;
            checkm[i] = false;
        }
    }
}

/*
dfs 를 만들때 중복을 제거한 조합을 찾는 방법이기 때문에 잘 써야한다.
for(int i = 0;i< chicken.size();i++){
            if(checkm[i])
                continue;
            checkm[i] = true;
            int[] now = chicken.get(i);
            board[now[0]][now[1]] = 2;
            dfs(v+1);
            board[now[0]][now[1]] = 0;
            checkm[i] = false;
        }
와 같이 했었는데 바로 시간초과...
 */
