package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ9095 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        for(int i = 0;i<testcase;i++){
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[1002];
            array[0] = 1;
            array[1] = 2;
            array[2] = 4;
            if(n>3){
                for(int j = 3;j<n;j++){
                    array[j] = array[j-1] + array[j-2] + array[j-3];
                }
            }
            bw.write(array[n-1]+"\n");
        }
        bw.flush();
    }
}
/*
* 1 = 1
* 2 = 2
* 3 = 4
* 4 = 7
* 5 = 13
*
* */