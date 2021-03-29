package BOJ.graph_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int v1 = Integer.parseInt(temp[0]);
        int v2 = Integer.parseInt(temp[1]);
        int result = 0;
        int[] len = new int[v1+1];
        boolean[] visited = new boolean[v1+1];
        int[][] board = new int[v1+1][v1+1];
        for(int i = 0;i<v2;i++){
            temp = br.readLine().split(" ");
            int temp1 = Integer.parseInt(temp[0]);
            int temp2 = Integer.parseInt(temp[1]);
            board[temp1][len[temp1]] = temp2;
            len[temp1]++;
            board[temp2][len[temp2]] = temp1;
            len[temp2]++;
        }
        Queue<Integer> queue = new LinkedList<>();
            for(int i = 1;i<v1+1;i++){
            if(!visited[i]){
                result ++;
                visited[i] = true;
                for(int k = 0;k<len[i];k++){
                    if(!visited[board[i][k]]){
                        visited[board[i][k]] = true;
                        queue.add(board[i][k]);
                    }
                }
                while(!queue.isEmpty()){
                    int thisvalue = queue.poll();
                    for(int k = 0;k<len[thisvalue];k++){
                        if(!visited[board[thisvalue][k]]){
                            visited[board[thisvalue][k]] = true;
                            queue.add(board[thisvalue][k]);
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
