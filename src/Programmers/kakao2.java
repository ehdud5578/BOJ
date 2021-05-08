package Programmers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class kakao2 {
    public static void main(String[] args){
        int[] result = new Solution().solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        for(int i = 0;i<5;i++){
            System.out.print(result[i] + " ");
        }
    }
    static class Solution {
        static int[] dy,dx;
        static boolean[][] visited;
        static boolean issafe;
        public int[] solution(String[][] places) {
            int[] answer = new int[5];
            dy = new int[]{0,1,0,-1};
            dx = new int[]{1,0,-1,0};
            visited = new boolean[5][5];
            for(int k = 0;k<5;k++){
                String[] thisboard = places[k];
                ArrayList<int[]> apply = new ArrayList<>();
                issafe = true;
                int[][] board = new int[5][5];
                for(int i = 0;i<5;i++){
                    String[] tmp = thisboard[i].split("");
                    for(int j = 0;j<5;j++){
                        if(tmp[j].equals("P")) {
                            board[i][j] = 1; // 사람있음
                            apply.add(new int[]{i,j,0});
                        }else if(tmp[j].equals("O")){
                            board[i][j] = 0; // 빈자리
                        }else{
                            board[i][j] = -1; // 벽
                        }
                    }
                }
                qq:
                for (int[] point : apply) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(point);
                    for (int i = 0; i < 5; i++) {
                        Arrays.fill(visited[i], false);
                    }
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        int nowy = now[0];
                        int nowx = now[1];
                        int distance = now[2];
                        if(distance>=2)
                            continue;
                        visited[nowy][nowx] = true;
                        for (int i = 0; i < 4; i++) {
                            int nexty = nowy + dy[i];
                            int nextx = nowx + dx[i];
                            if (nexty >= 0 && nexty < 5 && nextx >= 0 && nextx < 5) {
                                if (!visited[nexty][nextx]) {
                                    if(board[nexty][nextx]==1){
                                        issafe = false;
                                        break qq;
                                    }else if(board[nexty][nextx]==0){
                                        visited[nexty][nextx] = true;
                                        queue.add(new int[]{nexty,nextx,distance+1});
                                    }
                                }
                            }
                        }
                    }
                }
                if(issafe)
                    answer[k] = 1;
                else
                    answer[k] = 0;
            }
            return answer;
        }
    }
}
