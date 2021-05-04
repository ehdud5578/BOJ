package Programmers;

import java.util.HashMap;

public class kakao64062 { // 파라매트릭 서치 문제.
    public static void main(String[] args){
        int n = new Solution().solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3);
        System.out.println(n);
        int n1 = new Solution().solution(new int[]{5, 2, 2, 2, 2, 2, 2, 2, 2, 2},1);
        System.out.println(n1);
    }
    static class Solution{
        public int solution(int[] stones,int k){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = 0;i<stones.length;i++){
                max = Math.max(max,stones[i]);
                min = Math.min(min,stones[i]);
            }
            return search(stones,k,max,min);
        }
        public int search(int[] stones, int k, int max, int min){
            if (max == min) return min;
            int hi = max,lo = min;
            while (lo<hi){
                int mid = lo + (hi - lo) / 2;
                if(cancross(stones,k,mid)){
                    lo = mid+1;
                }else{
                    hi = mid;
                }
            }
            return lo -1;
        }
        public boolean cancross(int[] stones,int k,int mid){
            int crossed = 0;
            for(int ston:stones){
                if(ston-mid<0){
                    crossed++;
                }else{
                    crossed = 0;
                }
                if(crossed>=k)
                    return false;
            }
            return true;
        }
    }
}
/*
* static class Solution {
        public HashMap<Integer,Integer> map;
        public int solution(int[] stones, int k) {
            map = new HashMap<>();
            int answer = 0;
            qq:
            while (true){
                for(int i = 0;i<stones.length;i++){
                    if(stones[i]>0){
                        stones[i]--;
                        if(stones[i]==0){
                            map.put(i,1);
                        }
                    }else if(!map.containsKey(i)){
                        map.put(i,1);
                    }
                    else{
                        if(getdistance(i)<=k){
                            i+=getdistance(i);
                            if(i>= stones.length)
                                continue ;
                            stones[i]--;
                            if(stones[i]==0){
                                map.put(i,1);
                            }
                        }else
                            break qq;
                    }
                }
                answer++;
            }
            return answer;
        }
        public int getdistance(int n){
            int distance = map.get(n);
            if(map.containsKey(n+distance)){
                int next = distance+getdistance(n+distance);
                map.put(n,next);
                return distance + next;
            }else{
                return distance;
            }
        }
    }*/