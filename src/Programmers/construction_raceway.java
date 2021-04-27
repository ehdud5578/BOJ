package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class construction_raceway {
    public static void main(String[] args) {
        int result1 = new Solution().solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        int result2 = new Solution().solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}});
        int result3 = new Solution().solution(new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}});
        int result4 = new Solution().solution(new int[][]{{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}});
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    static class Solution {
        static int[] dy, dx;
        static int n;
        public int solution(int[][] board) {
            int[][] cost;
            n = board.length;
            cost = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(cost[i], Integer.MAX_VALUE);
            }
            dy = new int[]{0, 1, 0, -1};
            dx = new int[]{1, 0, -1, 0};
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0,-1,0});
            cost[0][0] = 0;
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int before = point[2];
                int nowcost = cost[point[0]][point[1]];
                if (point[0] == n - 1 && point[1] == n - 1) {
                    cost[point[0]][point[1]] = Math.min(cost[point[0]][point[1]],nowcost);
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int ny = point[0] + dy[i];
                    int nx = point[1] + dx[i];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                        if (board[ny][nx] == 0) {
                            int newcost = 0;
                            if (i == before||before == -1) {
                                newcost = point[3] + 100;
                            }else{
                                newcost = point[3] + 600;
                            }
                            if(cost[ny][nx]>=newcost){
                                cost[ny][nx] = newcost;
                                queue.add(new int[]{ny,nx,i,newcost});
                            }
                        }
                    }
                }
            }
            return cost[n - 1][n - 1];
        }
    }
}


/*
* static class Solution {
        static int[] dy, dx;
        static int n;
        static int answer;
        static int[][] board;

        public int solution(int[][] board) {
            answer = Integer.MAX_VALUE;
            this.board = board;
            n = board.length;
            dy = new int[]{0, 1, 0, -1};
            dx = new int[]{1, 0, -1, 0};
            int[][] cost;
            cost = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(cost[i], Integer.MAX_VALUE);
            }
            cost[0][0] = 100;
            if (board[0][1] == 0) {
                cost[0][1] = 100;
                dfs(0, 1, cost, 0);
            }
            if (board[1][0] == 0) {
                cost[1][0] = 100;
                dfs(1, 0, cost, 1);
            }

            return answer;
        }

        public static void dfs(int y, int x, int[][] cost, int before) {
            if (y == n - 1 && x == n - 1) {
                answer = Math.min(answer, cost[n - 1][n - 1]);
            }
            for (int i = 0; i < 4; i++) {
                int[][] ncost = new int[n][n];
                int thispoint = cost[y][x];
                for (int j = 0; j < n; j++) {
                    ncost[j] = Arrays.copyOf(cost[j], n);
                }
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                    if (board[ny][nx] == 0 && cost[ny][nx] == Integer.MAX_VALUE) {
                        if (i == before) {
                            ncost[ny][nx] = thispoint + 100;
                        } else {
                            ncost[ny][nx] = thispoint + 600;
                        }
                        dfs(ny, nx, ncost, i);
                    }
                }
            }
        }
    }
* */
/*
* static class Solution {
        static int[] dy, dx;
        static int n;
        public int solution(int[][] board) {
            int[][] cost;
            n = board.length;
            cost = new int[n][n];
            for(int i = 0;i<n;i++){
                Arrays.fill(cost[i],Integer.MAX_VALUE);
            }
            dy = new int[]{0, 1, 0, -1};
            dx = new int[]{1, 0, -1, 0};
            Queue<int[]> queue = new LinkedList<>();
            if(board[0][1]==0){
                queue.add(new int[]{0, 1, 0,100});//y,x,cost,before dir
                cost[0][1] = 100;
            }
            if(board[1][0]==0){
                queue.add(new int[]{1, 0, 1,100});//y,x,cost,before dir
                cost[1][0] = 100;
            }
            cost[0][0] = 100;
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int before = point[2];
                int nowcost = cost[point[0]][point[1]];
                for(int i = 0;i<4;i++){
                    int ny = point[0] + dy[i];
                    int nx = point[1] + dx[i];
                    if(ny>=0&&ny<n&&nx>=0&&nx<n){
                        if(board[ny][nx]==0){
                            if(i==before){
                                if(cost[ny][nx]>=nowcost+100){
                                    cost[ny][nx] = nowcost + 100;
                                    queue.add(new int[]{ny,nx,i});
                                }
                            }else{
                                if(cost[ny][nx]>=nowcost+600){
                                    cost[ny][nx] = nowcost + 600;
                                    queue.add(new int[]{ny,nx,i});
                                }
                            }
                        }
                    }
                }
            }
            return cost[n-1][n-1];
        }
    }*/
