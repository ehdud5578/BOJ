package BOJ.practice_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        int reuslt = factorial(n)/(factorial(k)*factorial(n-k));
        System.out.println(reuslt);

    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;
        else
        return n * factorial(n - 1);
    }
}
