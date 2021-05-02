package BOJ.practice_april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11052 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][n+1];
        StringTokenizer stz = new StringTokenizer(br.readLine());
        for(int i = 1;i<=n;i++){
            dp[i][0] = Integer.parseInt(stz.nextToken());
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                if(j%i==0){
                    dp[i][j] = dp[i][0]*(j/i);
                }
                dp[i][j] = Math.max(dp[i][j],dp[i-1][j]);
                for(int k = 1;k<=j/2;k++){
                    dp[i][j] = Math.max(dp[i][j],dp[i][j-k]+dp[i][k]);
                }
            }
        }
        System.out.println(dp[n][n]+" ");
    }
}
