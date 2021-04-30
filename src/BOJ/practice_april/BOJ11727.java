package BOJ.practice_april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11727 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] array  = new int[1002];
        array[0] = 1;
        array[1] = 3;
        for(int i = 2;i<n;i++){
            array[i] = (array[i-1] + 2 * array[i-2])% 10007;
        }
        bw.write(array[n-1] +"");
        bw.flush();
    }
}
