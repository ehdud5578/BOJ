package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        long result,cnt;
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        result = 1;
        cnt = 0;
        int recur = Math.min(k,n-k);
        for(int i = 1;i<=recur;i++){
            result = result *(n-i+1);
            result = result/i;
        }
        result = result%10007;
        System.out.println(result);
    }
}
