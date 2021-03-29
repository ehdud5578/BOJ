package BOJ.graph_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14226 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[10001][10001];
        board[1][0] = true;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0});
        qq:while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int[] now = q.poll();
                if(now[0]==n)
                    break qq;
                if(!board[now[0]][now[0]]){
                    board[now[0]][now[0]] = true;
                    q.add(new int[]{now[0],now[0]});
                }
                if(now[0]-1>0&&!board[now[0]-1][now[1]]){
                    board[now[0]-1][now[1]] = true;
                    q.add(new int[]{now[0]-1,now[1]});
                }
                if(!board[now[0]+now[1]][now[1]]){
                    board[now[0]+now[1]][now[1]] = true;
                    q.add(new int[]{now[0]+now[1],now[1]});
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
/*https://lovelyunsh.tistory.com/48 보고풀었음;
* 2시간넘게걸림;
*
* */