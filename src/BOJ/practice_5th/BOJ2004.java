package BOJ.practice_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2004 {
    static long n, m, result;
    static long combi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Long.parseLong(stz.nextToken());
        m = Long.parseLong(stz.nextToken());
        result = 0;
        combi = factorial(n) / (factorial(m) * factorial(n - m));
        while (true) {
            if ((combi % 10) == 0) {
                combi = combi / 10;
                result++;
            } else break;
        }
        System.out.println(result);
    }

    public static long factorial(long n) {
        if (n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }
}
