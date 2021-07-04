package Programmers;

import java.util.*;

public class naver_1 {
    public static void main(String[] args) {
        int result = new Solution().solution(new int[]{13000, 88000, 10000},new int[]{30, 20,0,0,0,0,0,});
        int result1 = new Solution().solution(new int[]{32000, 18000, 42500,5000,5000},new int[]{50, 20, 65});
        System.out.println(result);
        System.out.println(result1);
    }
    static class Solution {
        public int solution(int[] prices, int[] discounts) {
            Arrays.sort(prices);
            Arrays.sort(discounts);
            int answer = 0;
            int discountpoint  = discounts.length-1;
            for(int i = prices.length-1;i>=0;i--){
                prices[i] = prices[i]/100;
                prices[i] = prices[i] * (100-discounts[discountpoint]);
                answer +=prices[i];
                discounts[discountpoint] = 0;
                if(discountpoint>0)
                    discountpoint -=1;
            }
            return answer;
        }
    }
}
