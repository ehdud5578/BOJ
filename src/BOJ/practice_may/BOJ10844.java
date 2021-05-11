package BOJ.practice_may;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10844 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                dp[i][0] = dp[i - 1][1];
                for (int j = 1; j <= 8; j++) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
                dp[i][9] = dp[i - 1][8];
            }
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[n][i]) % 1000000000;
        }
        bw.write(result + " ");
        bw.flush();
    }
}
