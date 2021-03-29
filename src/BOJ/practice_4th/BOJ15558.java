package BOJ.practice_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15558 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,k;
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        boolean result = false;
        boolean[][] danger = new boolean[2][200000];
        boolean[][] visited = new boolean[2][200000];
        for(int i = 0;i<2;i++){
            Arrays.fill(danger[i],true);
        }
        for(int i = 0;i<2;i++){
            String[] temp = br.readLine().split("");
            for(int j = 0;j< temp.length;j++){
                danger[i][j] = Integer.parseInt(temp[j]) != 0;
            }
        }
        int time = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));
        visited[0][0] = true;
        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                Point now = q.poll();
                if(now.x>=n-1){
                    result = true;
                    break;
                }
                if(now.x-1>=0&&danger[now.y][now.x-1]&&now.x-1>time&&!visited[now.y][now.x-1]){
                    visited[now.y][now.x-1] = true;
                    q.add(new Point(now.x-1,now.y));
                }
                if(now.x+1<=100000&&danger[now.y][now.x+1]&&!visited[now.y][now.x+1]){
                    visited[now.y][now.x+1] = true;
                    q.add(new Point(now.x+1,now.y));
                }
                int nexty = 0;
                if (now.y != 1) {
                    nexty = 1;
                }
                if(now.x+k<=200000&&danger[nexty][now.x+k]&&!visited[nexty][now.x+k]){
                    visited[nexty][now.x+k] = true;
                    q.add(new Point(now.x+k,nexty));
                }
            }
            time++;
        }
        if(result)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
/*
if(now.x+k<=200000&&danger[nexty][now.x+k]&&!visited[nexty][now.x+k]){
조건문에서 200000 을써야하는데 100000을썻음

 */