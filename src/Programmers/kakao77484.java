package Programmers;

import java.util.HashSet;
import java.util.Set;

public class kakao77484 {
    public static void main(String[] args) {
        int[] result = new Solution().solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        System.out.println(result[0] + " " + result[1]);
        int[] result1 = new Solution().solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25});
        System.out.println(result1[0] + " " + result1[1]);
    }

    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int min = 0;
            int zeros = 0;
            Set<Integer> win = new HashSet<>();
            for (int i = 0; i < win_nums.length; i++) {
                win.add(win_nums[i]);
            }
            for (int i = 0; i < lottos.length; i++) {
                if (lottos[i] == 0)
                    zeros++;
                if (win.contains(lottos[i])) {
                    min++;
                }
            }
            int[] answer = new int[]{cal(min + zeros), cal(min)};
            return answer;
        }

        public static int cal(int n) {
            switch (n) {
                case 6:
                    return 1;
                case 5:
                    return 2;
                case 4:
                    return 3;
                case 3:
                    return 4;
                case 2:
                    return 5;
                default:
                    return 6;
            }
        }
    }
}
