package BOJ.practice_april;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2004 {
    public static int cnt,m,n;
    public static long cnt5,cnt2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        cnt = 0;
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        cnt5 = power_5(n) - power_5(n-m) - power_5(m);
        cnt2 = power_2(n) - power_2(n-m) - power_2(m);
        System.out.println(Math.min(cnt5,cnt2));
    }
    public static long power_5(int n){
        long cnt = 0;
        while(n>=5){
            cnt+=n/5;
            n = n/5;
        }
        return cnt;
    }
    public static long power_2(int n){
        long cnt = 0;
        while(n>=2){
            cnt+=n/2;
            n = n/2;
        }
        return cnt;
    }
}
/*
if(m<=n-m){
            for(int i = 2;i<=m;i++){
                result = result/i;
            }
            for(int i = n-m+1;i<=n;i++){
                result = result*i;
                checkbig();
            }
        }else{
            for(int i = 2;i<=n-m;i++){
                result = result/i;
            }
            for(int i = m;i<=n;i++){
                result = result*i;
                checkbig();
            }
        }

        public static void checkbig(){
        while(result%10==0){
            result = result/10;
            cnt++;
        }
    }
* */