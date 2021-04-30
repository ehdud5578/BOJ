package BOJ.practice_april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ4991 {
    static int w, h, startx, starty, dirtycnt, time, result;
    static int[][] board;
    static int[] dx, dy;
    static boolean[][] visited;
    static boolean[] select;
    static ArrayList<int[]> dust;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dy = new int[]{0, 1, 0, -1};
        dx = new int[]{1, 0, -1, 0};
        while (true) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            w = Integer.parseInt(stz.nextToken());
            h = Integer.parseInt(stz.nextToken());
            if (w == 0 && h == 0)
                break;
            board = new int[h][w];
            visited = new boolean[h][w];
            dust = new ArrayList<int[]>();
            dirtycnt = 0;
            time = 0;
            for (int i = 0; i < h; i++) {
                String[] temp = br.readLine().split("");
                for (int j = 0; j < w; j++) {
                    String tmp = temp[j];
                    if (tmp.equals(".")) {
                        board[i][j] = 0;
                    } else if (tmp.equals("x")) {
                        board[i][j] = -1;
                    } else if (tmp.equals("*")) {
                        board[i][j] = 0;
                        dirtycnt++;
                        dust.add(new int[]{i, j});
                    } else {
                        board[i][j] = 0;
                        startx = j;
                        starty = i;
                    }
                }
            }
            dfs(0,0, board);



            if (dirtycnt == 0) {
                bw.write(result + "\n");
            } else {
                bw.write("-1\n");
            }
        }
        bw.flush();
    }
    public static void dfs(int i,int v,int[][] thisboard){
        if(v==dirtycnt){
            return;
        }
        for(int k=0;k<dirtycnt;k++){
            if(select[k])
                continue;
            int[] adddust = dust.get(k);
            board[adddust[0]][adddust[1]] = 1;
        }

    }
}
/*
Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{starty, startx});

            qq:
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] thispoint = q.poll();
                    int nowy = thispoint[0];
                    int nowx = thispoint[1];
                    if (board[nowy][nowx] == 1) {
                        q.clear();
                        size = 1;
                        board[nowy][nowx] = 0;
                        result = time;
                        dirtycnt--;
                        if (dirtycnt == 0)
                            break qq;
                        for (int ty = 0; ty < h; ty++) {
                            Arrays.fill(visited[ty], false);
                        }

                    }
                    visited[nowy][nowx] = true;
                    for (int k = 0; k < 4; k++) {
                        int ny = nowy + dy[k];
                        int nx = nowx + dx[k];
                        if (ny >= 0 && ny < h && nx >= 0 && nx < w && !visited[ny][nx] && board[ny][nx] >= 0) {
                            visited[ny][nx] = true;
                            q.add(new int[]{ny, nx});
                        }
                    }
                }
                time++;
            }
 */