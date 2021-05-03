import java.lang.reflect.Array;
import java.util.ArrayList;

public class hotel {
    public static void main(String[] args){
        long[] answer = new Solution().solution(10,new long[]{1,3,4,1,3,1});
        for(int i = 0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }
    }
    static class Solution {
        public static ArrayList<Long> array,from,to;
        public long[] solution(long k, long[] room_number) {
            array = new ArrayList<>();
            from = new ArrayList<>();
            to = new ArrayList<>();
            for(int i = 0;i< room_number.length;i++){
                long n = room_number[i];
                long dest;
                if(from.contains(n)){
                    dest = to.get(from.indexOf(n));
                    check(n,dest);
                }else{
                    dest = n;
                    check(n,n+1);
                }
                array.add(dest);
            }
            long[] answer = new long[array.size()];
            for(int i = 0;i<array.size();i++){
                answer[i] = array.get(i);
            }
            return answer;
        }
        public static void check(long start,long dest){
            if(from.contains(dest)&&to.contains(start)){
                int s = from.indexOf(dest);
                int d = to.indexOf(start);
                from.set(s,to.get(d));
                from.add(start);
                to.add(to.get(d));
            }
            else if(from.contains(dest)&&!to.contains(start)){
                int s = from.indexOf(dest);
                from.set(s,start);
            }else if(!from.contains(dest)&&to.contains(start)){
                int s = to.indexOf(start);
                to.set(s,dest);
            }else{
                from.add(start);
                to.add(dest);
            }
        }
    }
}
// 효율 0퍼센트 고치다  말았음