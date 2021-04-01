package BOJ.practice_april;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13305 {
    public static int n;
    public static int[] lenth, price;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lenth = new int[n];
        price = new int[n];
        long result = 0;
        StringTokenizer stz = new StringTokenizer(br.readLine());
        for(int i = 0;i<n-1;i++){
            lenth[i] = Integer.parseInt(stz.nextToken());
        }
        stz = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            price[i] = Integer.parseInt(stz.nextToken());
        }
        int nowminprince = Integer.MAX_VALUE;
        for(int i = 0;i<n-1;i++){
            nowminprince = Math.min(nowminprince,price[i]);
            result += (long) nowminprince *lenth[i];
        }
        System.out.println(result);
    }
}
