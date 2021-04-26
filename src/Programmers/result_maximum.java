package Programmers;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class result_maximum {
    public static void main(String[] args)throws Exception {
        long sol = new Solution().solution("100-200*300-500+20");
        long sol2 = new Solution().solution("50*6-3*2");
        System.out.println(sol);
        System.out.println(sol2);
    }
    static class Solution {
        public static long answer;
        public long solution(String expression) {
            StringTokenizer stz = new StringTokenizer(expression,"-*+",true);
            ArrayList<String> exp = new ArrayList<String>();
            while (stz.hasMoreTokens()){
                exp.add(stz.nextToken());
            }
            answer = 0;
            cal(exp,"+","-","*");
            cal(exp,"+","*","-");
            cal(exp,"-","+","*");
            cal(exp,"*","+","-");
            cal(exp,"-","*","+");
            cal(exp,"*","-","+");
            return answer;
        }
        public static void cal(ArrayList<String> text,String cal1, String cal2, String cal3){
            ArrayList<String> expression = new ArrayList<>();
            expression.addAll(text);
            for(int i = 0;i< expression.size();i++){
                if(expression.get(i).equals(cal1)){
                    long v1 = Long.parseLong(expression.get(i-1));
                    long v2 = Long.parseLong(expression.get(i+1));
                    long result = calculate(v1,v2,cal1);
                    expression.remove(i-1);
                    expression.remove(i-1);
                    expression.remove(i-1);
                    expression.add(i-1,String.valueOf(result));
                    i = i-2;
                }
            }
            for(int i = 0;i< expression.size();i++){
                if(expression.get(i).equals(cal2)){
                    long v1 = Long.parseLong(expression.get(i-1));
                    long v2 = Long.parseLong(expression.get(i+1));
                    long result = calculate(v1,v2,cal2);
                    expression.remove(i-1);
                    expression.remove(i-1);
                    expression.remove(i-1);
                    expression.add(i-1,String.valueOf(result));
                    i = i-2;
                }
            }
            for(int i = 0;i< expression.size();i++){
                if(expression.get(i).equals(cal3)){
                    long v1 = Long.parseLong(expression.get(i-1));
                    long v2 = Long.parseLong(expression.get(i+1));
                    long result = calculate(v1,v2,cal3);
                    expression.remove(i-1);
                    expression.remove(i-1);
                    expression.remove(i-1);
                    expression.add(i-1,String.valueOf(result));
                    i = i-2;
                }
            }
            answer = Math.max(Math.abs(Long.parseLong(expression.get(0))),answer);
        }
        public static long calculate(long v1,long v2, String cal1){
            switch (cal1){
                case "+":
                    return v1+v2;
                case "-":
                    return v1-v2;
                case "*":
                    return v1*v2;
            }
            return 0;
        }
    }
}
// int 만 쓰다가 long 쓰려니까 생각보다 햇갈렸음..