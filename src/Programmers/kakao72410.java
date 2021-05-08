package Programmers;

import java.util.Locale;

public class kakao72410 {
    public static void main(String[] args){
        System.out.println(new Solution().solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(new Solution().solution("z-+.^."));
        System.out.println(new Solution().solution(	"=.="));
        System.out.println(new Solution().solution("123_.def"));
        System.out.println(new Solution().solution("abcdefghijklmn.p"));
    }
    static class Solution {
        public String solution(String new_id) {
            String step1 = new_id.toLowerCase();
            StringBuilder step2 = new StringBuilder();
            for(char c:step1.toCharArray()){
                if((c>='a'&&c<='z')||(c>='0'&&c<='9')||c=='_'||c=='-'||c=='.'){
                    step2.append(c);
                }
            }
            String step3 = step2.toString();
            while (step3.contains("..")){
                step3 = step3.replace("..",".");
            }
            String step4 = step3;
            if(step4.startsWith(".")){
                step4 = step4.substring(1,step4.length());
            }
            if(step4.endsWith(".")){
                step4 = step4.substring(0,step4.length()-1);
            }
            String step5 = step4;
            if(step5.equals("")){
                step5 = "a";
            }
            String step6 = step5;
            if(step6.length()>=16){
                step6 = step6.substring(0,15);
                if (step6.endsWith(".")){
                    step6 = step6.substring(0,14);
                }
            }
            StringBuilder step7 = new StringBuilder(step6);
            if(step7.length()<=2){
                char c = step7.toString().toCharArray()[step7.length()-1];
                while (step7.length()<3){
                    step7.append(c);
                }
            }
            return step7.toString();
        }
    }
}
