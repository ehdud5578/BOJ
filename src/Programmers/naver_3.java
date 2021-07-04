package Programmers;

import java.util.LinkedList;

public class naver_3 {
    public static void main(String[] args) {
        int result = new Solution().solution("aabcbcd","abc");
        System.out.println(result);
        int result1 = new Solution().solution("aaaaabbbbb","ab");
        System.out.println(result1);
    }
    static class Solution {
        public int solution(String s, String t) {
            char[] replace = t.toCharArray();
            char[] inputlist = s.toCharArray();
            int result = 0;
            LinkedList<Character> board = new LinkedList<>();
            for(int i = 0;i<inputlist.length;i++){
                board.add(inputlist[i]);
            }
            qq:for(int i = 0;i<=board.size()-t.length();i++){
                for(int j = 0;j<t.length();j++){
                    if(!board.get(i+j).equals(replace[j]))
                        continue qq;
                }
                result ++;
                for(int k = 0;k< replace.length;k++){
                    board.remove(i);
                }
                i = i- replace.length;
                if(i<0)
                    i = -1;
            }
            return result;
        }
    }
}
