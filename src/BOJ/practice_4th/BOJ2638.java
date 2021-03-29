package BOJ.practice_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638 {
    static int h, w, chsize,time;
    static int[][] board, deletech;
    static int[] dy, dx;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        h = Integer.parseInt(stz.nextToken());
        w = Integer.parseInt(stz.nextToken());
        board = new int[h][w];
        deletech = new int[h][w];
        time = 0;
        visited = new boolean[h][w];
        dy = new int[]{0, 1, 0, -1};
        dx = new int[]{1, 0, -1, 0};
        chsize = 0;
        for (int i = 0; i < h; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
                if (board[i][j] == 1)
                    chsize++;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        while(true){
            for(int i = 0;i<h;i++){
                Arrays.fill(deletech[i],0);
                Arrays.fill(visited[i],false);
            }
            queue.add(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                visited[now[0]][now[1]] = true;
                for (int i = 0; i < 4; i++) {
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if (ny >= 0 && ny < h && nx >= 0 && nx < w && !visited[ny][nx]) {
                        if (board[ny][nx] == 0) {
                            queue.add(new int[]{ny, nx});
                            visited[ny][nx] = true;
                        } else {
                            deletech[ny][nx]++;
                        }

                    }
                }
            }
            for(int i = 0;i<h;i++){
                for(int j = 0;j<w;j++){
                    if(deletech[i][j]>=2){
                        board[i][j] = 0;
                        chsize--;
                    }
                }
            }
            time++;
            if(chsize<=0)
                break;
        }
        System.out.println(time);
    }
}
/*
삭제연산에서
arraylist 로 썻을때 304ms
이중 포문으로 썻을때 228ms

 */