package Programmers;

import java.util.ArrayList;

public class naver_2 {
    public static void main(String[] args) {
        String[] result = new Solution().solution("abcdef");
        for(int i = 0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
    static class Solution {
        public String[] solution(String s) {

            ArrayList<String> answer1 = new ArrayList<>();
            int pointer = 1;
            String start = "";
            String end = "";
            while (pointer<=s.length()/2){
                start = s.substring(0,pointer);
                end = s.substring(s.length()-pointer,s.length());
                if (start.equals(end)){
                    answer1.add(answer1.size()/2,start);
                    answer1.add(answer1.size()/2,end);
                    s = s.substring(pointer,s.length()-pointer);
                    pointer = 1;
                }else{
                    pointer+=1;
                }
            }
            if(s.length()>=1){
                answer1.add(answer1.size()/2,s);
            }
            String[] answer = new String[answer1.size()];
            for(int i = 0;i<answer.length;i++){
                answer[i] = answer1.get(i);
            }
            return answer;
        }
    }
}
