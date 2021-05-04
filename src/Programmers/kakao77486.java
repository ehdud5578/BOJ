package Programmers;

import java.util.Arrays;

public class kakao77486 {
    public static void main(String[] args) {
        int[] result = Solution.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{1, 4, 2, 5, 10});
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }

    static class Solution {
        public static int[] answer;

        public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            answer = new int[enroll.length];
            for (int i = 0; i < seller.length; i++) {
                String sel = seller[i];
                int index = Arrays.asList(enroll).indexOf(sel);
                int price = amount[i] * 100;
                dist(index, price, referral,enroll);
            }
            return answer;
        }

        public static void dist(int i, int price, String[] referral,String[] enroll) {
            int remaind = (int) Math.floor(price*0.1);
            int my = price - remaind;
            if (referral[i].equals("-")) {
                answer[i] += my;
            } else {
                answer[i] += my;
                dist(Arrays.asList(enroll).indexOf(referral[i]), remaind, referral,enroll);
            }
        }
    }
}
