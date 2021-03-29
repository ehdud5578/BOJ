package BOJ.practice_5th;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17822 {
    static int n, m, t, xi, di, ki,result;
    static int[][] board;
    static int[] ny,nx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        t = Integer.parseInt(stz.nextToken());
        board = new int[n + 1][m];
        ny = new int[]{0,1,0,-1};
        nx = new int[]{1,0,-1,0};
        result = 0;
        for (int i = 1; i <= n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        for (int i = 0; i < t; i++) {
            stz = new StringTokenizer(br.readLine());
            xi = Integer.parseInt(stz.nextToken());
            di = Integer.parseInt(stz.nextToken());
            ki = Integer.parseInt(stz.nextToken());
            cal(xi,di,ki);
        }
        for(int i = 1;i<=n;i++){
            for(int j =0;j<m;j++){
                result += board[i][j];
            }
        }
        bw.write(result+"\n");
        bw.flush();
    }
    public static void cal(int x,int d,int k){
        for(int i = x;i<=n;i+=x){
            for(int e = 0;e<k;e++){
                if (d == 0) {//시계 방향
                    int temp = board[i][m-1];
                    for (int j = m-1; j > 0; j--) {
                        board[i][j] = board[i][j - 1];
                    }
                    board[i][0] = temp;
                } else { // 반시계 방향
                    int temp = board[i][0];
                    for (int j = 0; j < m - 1; j++) {
                        board[i][j] = board[i][j + 1];
                    }
                    board[i][m-1] = temp;
                }
            }
        }
        boolean[][] visited = new boolean[n+1][m];
        Queue<int[]> queue = new LinkedList<>();
        boolean isdelete = false;
        for(int dy = 1;dy<=n;dy++){
            for(int dx = 0;dx<m;dx++){
                int thisvalue = board[dy][dx];
                visited[dy][dx] = true;
                queue.add(new int[]{dy,dx});
                while (!queue.isEmpty()){
                    int[] thispoint = queue.poll();
                    for (int dk = 0; dk < 4; dk++) {
                        int nextx = (thispoint[1] + nx[dk] + m) % m;
                        int nexty = thispoint[0] + ny[dk];
                        if (nexty >= 1 && nexty <= n && nextx >= 0 && nextx < m) {
                            if (thisvalue == board[nexty][nextx] && thisvalue != 0) {
                                queue.add(new int[]{nexty, nextx});
                                isdelete = true;
                                board[thispoint[0]][thispoint[1]] = 0;
                                board[nexty][nextx] = 0;
                            }
                        }
                    }
                }
            }
        }
        if(!isdelete){
            int cnt = 0;
            int sum = 0;
            for(int dy = 1;dy<=n;dy++){
                for(int dx = 0;dx<m;dx++){
                    if(board[dy][dx]!=0){
                        cnt++;
                        sum+=board[dy][dx];
                    }
                }
            }
            float average = (float)sum/cnt;
            for(int dy = 1;dy<=n;dy++){
                for(int dx = 0;dx<m;dx++){
                    if(board[dy][dx]!=0){
                        if(board[dy][dx]>average){
                            board[dy][dx]--;
                        }else if(board[dy][dx]<average){
                            board[dy][dx]++;
                        }
                    }
                }
            }
        }

    }
}
