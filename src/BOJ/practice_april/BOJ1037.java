package BOJ.practice_april;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1037 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringTokenizer stz = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            int value = Integer.parseInt(stz.nextToken());
            max = Math.max(max,value);
            min = Math.min(min,value);
        }
        int result = max * min;
        System.out.println(result);
    }
}
