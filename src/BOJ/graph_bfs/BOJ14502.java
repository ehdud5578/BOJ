package BOJ.graph_bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    static int n,m,result;
    static int[][] board;
    static int[] dx,dy;
    static ArrayList<int[]> q;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        q = new ArrayList<>();
        board = new int[n][m];
        result = 0;
        dx = new int[]{1,0,-1,0};
        dy = new int[]{0,1,0,-1};
        for(int i = 0;i<n;i++){
            stz = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                board[i][j] = Integer.parseInt(stz.nextToken());
                if(board[i][j]==2)
                    q.add(new int[]{i,j});
            }
        }
        for(int y1 = 0;y1<n;y1++){
            for(int x1 = 0;x1<m;x1++){
                if(board[y1][x1]==0){
                    board[y1][x1] = 1;
                    for(int y2 = 0;y2<n;y2++){
                        for(int x2 = 0;x2<m;x2++){
                            if(board[y2][x2]==0){
                                board[y2][x2] = 1;
                                for(int y3 = 0;y3<n;y3++){
                                    for(int x3 = 0;x3<m;x3++){
                                        if(board[y3][x3]==0){
                                            board[y3][x3] = 1;
                                            bfs();
                                            board[y3][x3] = 0;
                                        }

                                    }
                                }
                                board[y2][x2] = 0;
                            }
                        }
                    }
                    board[y1][x1] = 0;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
    public static void bfs(){
        int[][] clone = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i<q.size();i++){
            queue.add(q.get(i));

        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                clone[i][j] = board[i][j];
            }
        }
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0;i<4;i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny>=0&&ny<n&&nx>=0&&nx<m){
                    if(clone[ny][nx]==0){
                        clone[ny][nx] = 2;
                        queue.add(new int[]{ny,nx});
                    }
                }
            }
        }
        int thisresult = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(clone[i][j]==0)
                    thisresult++;
            }
        }
        result = Math.max(result,thisresult);
    }
}
