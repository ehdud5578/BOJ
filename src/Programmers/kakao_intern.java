package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class kakao_intern {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  =new BufferedWriter(new OutputStreamWriter(System.out));
        int[] number = new int[11];
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int i = 0;
        while (stz.hasMoreTokens()){
            number[i] = Integer.parseInt(stz.nextToken());
            i++;
        }
        String hand = br.readLine();
        String sol = new Solution().solution(number,hand);
        bw.write(sol);
        bw.flush();
    }
    static class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            int leftx,lefty,rightx,righty;
            leftx = 0;
            lefty = 3;
            righty = 3;
            rightx = 2;
            int[] numberlocx,numberlocy;
            numberlocx = new int[]{1,0,1,2,0,1,2,0,1,2};
            numberlocy = new int[]{3,0,0,0,1,1,1,2,2,2};
            for(int i = 0;i<numbers.length;i++){
                int n = numbers[i];
                if(n==1||n==4||n==7){
                    answer = answer.concat("L");
                    lefty = numberlocy[n];
                    leftx = numberlocx[n];
                }else if(n==3||n==6||n==9){
                    answer = answer.concat("R");
                    righty = numberlocy[n];
                    rightx = numberlocx[n];
                }
                else{
                    int leftlen = Math.abs(numberlocx[n]-leftx) + Math.abs(numberlocy[n]-lefty);
                    int rightlen = Math.abs(numberlocx[n] - rightx) + Math.abs(numberlocy[n]-righty);
                    if(leftlen==rightlen){
                        if(hand.equals("right")){
                            answer = answer.concat("R");
                            righty = numberlocy[n];
                            rightx = numberlocx[n];
                        } else{
                            answer = answer.concat("L");
                            lefty = numberlocy[n];
                            leftx = numberlocx[n];
                        }
                    }else if(leftlen>rightlen){
                        answer = answer.concat("R");
                        righty = numberlocy[n];
                        rightx = numberlocx[n];
                    }else{
                        answer = answer.concat("L");
                        lefty = numberlocy[n];
                        leftx = numberlocx[n];
                    }
                }

            }
            return answer;
        }
    }
}
