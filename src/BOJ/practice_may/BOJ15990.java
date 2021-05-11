package BOJ.practice_may;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ15990 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int max = 3;
        long[][] dp = new long[100002][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int j = 0;j<n;j++){
            int num = Integer.parseInt(br.readLine());
            if(max<num){
                for (int i = max+1; i <= num; i++) {
                    dp[i][1] = (dp[i - 1][2] + dp[i - 1][3])%1000000009;
                    dp[i][2] = (dp[i - 2][1] + dp[i - 2][3])%1000000009;
                    dp[i][3] = (dp[i - 3][1] + dp[i - 3][2])%1000000009;
                }
                max = num;
            }
            long result = (dp[num][1] + dp[num][2] + dp[num][3])%1000000009;
            bw.write(result + "\n");
        }
        bw.flush();
    }
}
