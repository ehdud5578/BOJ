package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4991 {
    static class Point{
        int y;
        int x;
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static ArrayList<Point> list;
    static int y,x,answer;
    static char[][] board;
    static int[][] distance;
    static boolean[] selected;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true){
            StringTokenizer stz = new StringTokenizer(br.readLine());
            x = Integer.parseInt(stz.nextToken());
            y = Integer.parseInt(stz.nextToken());
            if(y==0&&x==0)
                break;
            board = new char[y][x];
            list = new ArrayList<>();
            for(int i = 0;i<y;i++){
                char[] temp1= br.readLine().toCharArray();
                for(int j = 0;j<x;j++){
                    board[i][j] = temp1[j];
                    if(board[i][j]=='o'){
                        list.add(0,new Point(i,j));
                    }else if(board[i][j]=='*'){
                        list.add(new Point(i,j));
                    }
                }
            }
            int size = list.size();
            distance = new int[size][size];
            selected = new boolean[size];
            for(int idx = 0;idx<size;idx++){
                if(!isreachable(idx)){
                    answer = -1;
                    break;
                }
            }
            if (answer != -1) {
                answer = Integer.MAX_VALUE;
                selected[0] = true;
                dfs(0, 0, 0);
            }
            bw.write(answer + "\n");
        }
        bw.flush();
    }

    private static void dfs(int d,int dist,int from) {
        if(d== selected.length-1){
            answer = Math.min(answer, dist);
            return;
        }
        for(int to = 1; to< selected.length;to++){
            if(!selected[to]){
                selected[to] = true;
                dfs(d+1,dist + distance[from][to],to);
                selected[to] = false;
            }
        }
    }

    private static boolean isreachable(int idx) {
        boolean[][] visited = new boolean[y][x];
        int[] dy = new int[]{0,1,0,-1},dx = new int[]{1,0,-1,0};
        Queue<Point> q = new LinkedList<>();

        int dust = 0;
        int cnt = 0;
        Point start = list.get(idx);
        visited[start.y][start.x] = true;
        q.add(start);
        while (!q.isEmpty()){
            int size = q.size();
            cnt++;
            for(int i = 0;i<size;i++){
                Point current = q.poll();
                for(int d = 0;d<4;d++){
                    int ny = current.y + dy[d];
                    int nx = current.x + dx[d];
                    if (ny >= y || ny < 0 || nx >= x || nx < 0 || visited[ny][nx] || board[ny][nx] == 'x')
                        continue;
                    if(board[ny][nx]=='o'||board[ny][nx]=='*'){
                        for(int to = 0;to<list.size();to++){
                            Point end = list.get(to);
                            if(end.y==ny&&end.x==nx){
                                distance[idx][to] = cnt;
                                distance[to][idx] = cnt;
                                dust++;
                            }
                        }
                    }
                    visited[ny][nx] = true;
                    q.offer(new Point(ny,nx));
                }
            }
        }
        return dust == list.size() - 1;
    }
}
/*
* https://data-make.tistory.com/642
* 처음에 풀었을 때는 문제를 잘못 이해했었다.
* 더러운 곳을 모두 청소할 수는 있었지만 최단 거리가 아니었음.
* 최단거리를 구하기 위해 거리를 계산한
* */