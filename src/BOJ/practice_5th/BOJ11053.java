package BOJ.practice_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11053 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(cnt,0);
        StringTokenizer stz = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            array[i] = Integer.parseInt(stz.nextToken());
        }
        for(int i = n-1;i>0;i--){
            for(int j = i-1;j>=0;j--){
                if(array[j]<array[i])
                    cnt[j]++;
            }
        }
        int maxvalue = 0;
        for(int i = 0;i<n;i++){
            if(cnt[i]>maxvalue)maxvalue = cnt[i];
        }
        System.out.println(maxvalue);
    }
}
