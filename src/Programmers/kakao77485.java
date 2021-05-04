package Programmers;

public class kakao77485 {
    public static void main(String[] args) {
        int[] result = new Solution().solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
        for(int i = 0;i< result.length;i++){
            System.out.print(result[i] + " ");
        }
    }

    static class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];
            int[][] board = new int[rows][columns];
            int k = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    board[i][j] = (i * columns) + (j + 1);
                }
            }

            for (int m = 0;m< queries.length;m++) {
                int[] sqr = queries[m];
                int min = Integer.MAX_VALUE;
                int dy = sqr[2] - sqr[0];
                int dx = sqr[3] - sqr[1];
                int ny = sqr[0] - 1;
                int nx = sqr[1] - 1;
                int temp = board[ny][nx];
                min = Math.min(temp,min);
                for(int i = 0;i<dy;i++){
                    min = Math.min(board[ny][nx],min);
                    board[ny][nx] = board[ny+1][nx];
                    ny+=1;
                }
                for(int i = 0;i<dx;i++){
                    min = Math.min(board[ny][nx],min);
                    board[ny][nx] = board[ny][nx+1];
                    nx+=1;
                }
                for(int i = 0;i<dy;i++){
                    min = Math.min(board[ny][nx],min);
                    board[ny][nx] = board[ny-1][nx];
                    ny = ny-1;
                }
                for(int i = 0;i<dx-1;i++){
                    min = Math.min(board[ny][nx],min);
                    board[ny][nx] = board[ny][nx-1];
                    nx = nx-1;
                }
                min = Math.min(board[ny][nx],min);
                board[ny][nx] = temp;
                answer[m] = min;
            }
            return answer;
        }
    }
}
