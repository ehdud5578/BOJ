package BOJ.practice_april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ15988 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        long[] array = new long[1000002];
        array[0] = 1;
        array[1] = 2;
        array[2] = 4;
        int max = 3;
        for(int i = 0;i<testcase;i++){
            int n = Integer.parseInt(br.readLine());
            if(n>max){
                max = n;
                for(int j = 3;j<n;j++){
                    array[j] = (array[j-1] + array[j-2] + array[j-3])%1000000009; // 10억 + 10억 + 10억 = overflow
                }
            }

            bw.write(array[n-1]+"\n");
        }
        bw.flush();
    }
}