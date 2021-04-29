package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class jewellery_shopping {
    public static void main(String[] args){
        int[] sol1 = Solution.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        int[] sol2 = Solution.solution(new String[]{"AA", "AB", "AC", "AA", "AC"});
        int[] sol3 = Solution.solution(new String[]{"XYZ", "XYZ", "XYZ"});
        int[] sol4 = Solution.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
        System.out.println(sol1[0]+" "+sol1[1]);
        System.out.println(sol2[0]+" "+sol2[1]);
        System.out.println(sol3[0]+" "+sol3[1]);
        System.out.println(sol4[0]+" "+sol4[1]);
    }
    static class Solution {
        public static int[] solution(String[] gems) {
            Queue<String> q = new LinkedList<String>();
            HashSet<String> hs = new HashSet<String>();
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            int startPoint = 0;
            int length = Integer.MAX_VALUE;
            int[] answer;
            for(String g : gems) {
                hs.add(g);
            }
            int start = 0;
            for(int i = 0; i < gems.length; i++) {
                if(!hm.containsKey(gems[i])) hm.put(gems[i], 1);
                else hm.put(gems[i], hm.get(gems[i]) + 1);
                q.add(gems[i]);
                while(true) {
                    String temp = q.peek();
                    if(hm.get(temp) > 1) {
                        hm.put(temp, hm.get(temp) - 1);
                        q.poll();
                        startPoint++;
                    }
                    else {
                        break;
                    }
                }
                if(hm.size() == hs.size() && length > q.size()) {
                    length = q.size();
                    start = startPoint;
                }
            }
            return new int[]{start + 1, start + length};
        }
    }
}
/*
* static class Solution {
        int n;
        public int[] solution(String[] gems) {
            this.n = gems.length;
            int[] answer = {0,0};
            HashSet<String> jewellery = new HashSet<>(Arrays.asList(gems));
            Object[] valueList = jewellery.toArray();
            ArrayList<String> resultset = new ArrayList<>();
            boolean[] visited = new boolean[jewellery.size()];
            for(int i = 0;i< jewellery.size();i++){
                resultset.add((String) valueList[i]);
            }
            qq:for(int i = 0;i<gems.length;i++){
                for(int j = 0;j+i<gems.length;j++){
                    String[] subset = Arrays.copyOfRange(gems,j,j+i+1);
                    Arrays.fill(visited,false);
                    for(int k = 0;k< subset.length;k++){
                        visited[resultset.indexOf(subset[k])] = true;
                    }
                    boolean istrue = true;
                    for(int k = 0;k< jewellery.size();k++){
                        if (!visited[k]){
                            istrue = false;
                            break;
                        }
                    }
                    if(istrue){
                        answer[0] = j+1;
                        answer[1] = j+i+1;
                        break qq;
                    }
                }
            }
            return answer;
        }
    }*/