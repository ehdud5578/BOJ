package Programmers;

import java.util.ArrayList;
import java.util.Stack;

public class Cranes_doll {
    public static void main(String[] args) {
        int result = new Solution().solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4});
        int result1 = new Solution().solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4});
        int result2 = new Solution().solution(new int[][]{{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3}}, new int[]{1,5,3,5,1,2,1,4});
        int result3 = new Solution().solution(new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}}, new int[]{1,5,3,5,1,2,1,4});
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    static class Solution {
        public int solution(int[][] board, int[] moves){
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            for(int move:moves){
                for(int j = 0;j<board.length;j++){
                    if(board[j][move-1]!=0){
                        if(stack.peek()==board[j][move-1]){
                            stack.pop();
                            answer +=2;
                        }else{
                            stack.add(board[j][move-1]);
                        }
                        board[j][move-1] = 0;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
/*
* public int solution(int[][] board, int[] moves) {
            int answer = 0;
            ArrayList<Integer> basket = new ArrayList<>();
            for (int move : moves) {
                int j = 0;
                while (board[j][move - 1] == 0) {
                    j++;
                    if(j==board.length)
                        break;
                }
                if(j<board.length){
                    basket.add(board[j][move - 1]);
                    board[j][move - 1] = 0;
                }
            }
            for (int j = 0; j < basket.size()-1; j++) {
                if (basket.get(j).equals(basket.get(j + 1))) {
                    basket.remove(j);
                    basket.remove(j);
                    if(j>2)
                        j=j-2;
                    else
                        j=0;
                    answer += 2;
                }
            }
            return answer;
        }*/