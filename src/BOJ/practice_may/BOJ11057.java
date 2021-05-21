package BOJ.practice_may;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11057 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[1001][11];
        for(int i = 0;i<10;i++){
            dp[1][i] = 1;
        }
        if(n>1){
            for(int i = 2;i<=n;i++){
                for(int j = 9;j>=0;j--){
                    dp[i][j] = (dp[i][j+1] + dp[i-1][j])%10007;
                }
            }
        }
        int result = 0;
        for(int i = 0;i<10;i++){
            result  += dp[n][i];
        }
        bw.write(result%10007 + " ");
        bw.flush();
    }
}
