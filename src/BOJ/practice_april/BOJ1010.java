package BOJ.practice_april;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1010 {
    public static int n, m, testcase;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            m = Integer.parseInt(stz.nextToken());
            n = Integer.parseInt(stz.nextToken());
            long result = 1;
            int recur = Math.min(m, n - m);
            for(int k = 1;k<=recur;k++){
                result = result * (n-k+1);
                result = result/k;
            }
            bw.write(result+"\n");
        }
        bw.flush();
    }
}
