package Programmers;

import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class kakao3 {
    public static void main(String[] args){
        String result = new Solution().solution(8,2,new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
        System.out.println(result);
        String result1 = new Solution().solution(8,2,new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"});
        System.out.println(result1);
    }
    static class Solution {
        boolean[] list;
        public String solution(int n, int k, String[] cmd) {
            list = new boolean[n];
            Arrays.fill(list,true);
            int cnt;
            Stack<Integer> stack = new Stack<>();
            for(String command:cmd){
                if(command.startsWith("D")){ // ++
                    StringTokenizer stz = new StringTokenizer(command);
                    stz.nextToken();
                    cnt = Integer.parseInt(stz.nextToken());
                    k = move(k,cnt,1);
                }else if(command.startsWith("U")){ // --
                    StringTokenizer stz = new StringTokenizer(command);
                    stz.nextToken();
                    cnt = Integer.parseInt(stz.nextToken());
                    k = move(k,cnt,-1);
                }else if(command.equals("C")){
                    list[k] = false;
                    stack.add(k);
                    if(k==list.length-1){
                        k = move(k,1,-1);
                    }else {
                        k = move(k, 1, 1);
                    }
                }else if(command.equals("Z")){
                    if(stack.peek()!=-1){
                        list[stack.pop()] = true;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<list.length;i++){
                if(list[i]){
                    sb.append("O");
                }else{
                    sb.append("X");
                }
            }
            return sb.toString();
        }
        public int move(int k,int n,int dir){
            if(dir==1){
                int startn = n;
                int tempk = k;
                while (n>0){
                    if(list[++tempk]){
                        n--;
                    }
                    if(tempk==list.length-1){
                        break;
                    }
                }
                if(startn==n){
                    return move(k,1,-1);
                }
                return tempk;
            }else{
                int startn = n;
                int tempk = k;
                while (n>0){
                    if(list[--tempk]){
                        n--;
                    }
                    if(tempk==list.length-1){
                        break;
                    }
                }
                if(startn==n){
                    return move(k,1,1);
                }
                return tempk;
        }
    }
}
}
