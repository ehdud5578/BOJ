package BOJ.practice_april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11051 {
    static int[][] dp;
    static int div;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        div = 10007;
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        dp = new int[n+1][n+1];
        System.out.println(cal(n,k));
    }
    public static int cal(int n,int k){
        if(dp[n][k]>0)
            return dp[n][k];
        if(k==0||n==k)
            return 1;
        return dp[n][k] = (cal(n-1,k-1) + cal(n-1,k))%div;
    }
}
/*페르마의 소정리를 배웠었는데 기억이 안난다.
* 분명히 배운건데 문제를 보면 이걸 어떻게 이용해야겠다는 생각이 들지 않는다.
*
*
* main {
 *   n! / ((n-k)! * k!)   ->   n! * ((n-k)! * k!)^(-1) 으로 변환
 *   ((n-k)! * k!)^(-1) == ((n-k)! * k!)^(p-2) 동치
 *   p(=div)가 소수여서 가능함)
    print((factorial(N) * mod_inverse((factorial(N - K) * factorial(K)) % div, div - 2)) % div);
}

        int factorial(int N) {
        if(N == 0) {
        return 1;
        }
        return N * factorial(N - 1);
        }

// 역원 구하기 (= 제곱승 구하기)
        int mod_inverse(int a, int p) {
        int ret = 1;
        while(p > 0) {
        if(p % 2 == 1) {
        ret *= a;
        p--;
        ret %= div;
        }
        a *= a;
        a %= div;
        p >>= 1;	// p = p/2 랑 동치
        }
        return ret;
        }
*/
