package Programmers;

import java.util.*;

public class tuple {
    public static void main(String[] args){
        int[] result1 = new Solution().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        int[] result2 = new Solution().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        int[] result3 = new Solution().solution("{{123}}");
        int[] result4 = new Solution().solution("{{20,111},{111}}");
        int[] result5 = new Solution().solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
        System.out.println(Arrays.toString(Arrays.stream(result1).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(result2).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(result3).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(result4).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(result5).toArray()));
    }
    static class Solution {
        public int[] solution(String s) {
            StringTokenizer stz = new StringTokenizer(s,"{},");
            HashMap<Integer, Integer> map = new HashMap<>();
            HashSet<Integer> keys = new HashSet<>();
            while (stz.hasMoreTokens()){
                int n = Integer.parseInt(stz.nextToken());
                if(map.containsKey(n)){
                    map.put(n,map.get(n)+1);
                }else{
                    map.put(n,1);
                }
                keys.add(n);
            }
            int[] answer = new int[map.size()];
            Iterator iterator = keys.iterator();
            for(int i = 0;i<map.size();i++){
                int key = (int) iterator.next();
                answer[map.size()-(map.get(key))] = key;
            }
            return answer;
        }
    }
}
