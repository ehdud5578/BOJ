package BOJ.practice_april;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17837 {
    static int n, k;
    static int[][] board;
    static Horse[] horses;
    static int[] dy, dx; //0,→, ←, ↑, ↓
    static ArrayList<Integer>[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        dy = new int[]{0, 0, 0, -1, 1};
        dx = new int[]{0, 1, -1, 0, 0};
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        board = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {     //0은 흰색, 1은 빨간색, 2는 파란색
            stz = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        map = new ArrayList[n+1][n+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                map[i][j] = new ArrayList<>();
            }
        }
        horses = new Horse[k + 1];
        for (int i = 1; i <= k; i++) {
            stz = new StringTokenizer(br.readLine());
            int dy = Integer.parseInt(stz.nextToken());
            int dx = Integer.parseInt(stz.nextToken());
            int dir = Integer.parseInt(stz.nextToken());
            horses[i] = new Horse(i,dy, dx, dir);
            map[dy][dx].add(i);
        }
        gamestart();
    }
    public static void gamestart(){
        int time = 0;
        while(time<1000){
            time++;
            for(int i = 1;i<=k;i++){
                if (move(i)) {
                    System.out.println(time);
                    return;
                }
            }
        }
        System.out.println("-1\n");
    }

    public static boolean move(int i){
    Horse now = horses[i];
    int nexty = now.y + dy[now.dir];
    int nextx = now.x + dx[now.dir];
    if(nexty>n||nexty<1||nextx>n||nextx<1||board[nexty][nextx]==2){
        if(now.dir==1||now.dir==3){
            horses[i].dir++;
        }else{
            horses[i].dir--;
        }
        nexty = now.y + dy[now.dir];
        nextx = now.x + dx[now.dir];
    }
    if(nexty<=n&&nexty>=1&&nextx>=1&&nextx<=n&&board[nexty][nextx]!=2){
        ArrayList<Integer> from = map[now.y][now.x];
        ArrayList<Integer> to = map[nexty][nextx];
        int height = from.indexOf(now.id);
        int fromsize = from.size();
        switch (board[nexty][nextx]){
            case 0:
                for(int q = height;q<fromsize;q++){
                    int hors = from.get(q);
                    horses[hors].y = nexty;
                    horses[hors].x = nextx;
                    to.add(hors);
                }
                for(int q = fromsize-1;q>=height;q--){
                    from.remove(q);
                }
                break;
            case 1:
                for(int q = fromsize-1;q>=height;--q){
                    int hors = from.get(q);
                    horses[hors].y = nexty;
                    horses[hors].x = nextx;
                    to.add(hors);
                }
                for(int q = fromsize-1;q>=height;q--){
                    from.remove(q);
                }
                break;
        }
        return map[nexty][nextx].size() >= 4;
    }
    return false;
    }
}

class Horse {
    public Horse(int id, int y, int x, int dir) {
        this.id = id;
        this.y = y;
        this.x = x;
        this.dir = dir;
    }
    int id;
    int y;
    int x;
    int dir;
}