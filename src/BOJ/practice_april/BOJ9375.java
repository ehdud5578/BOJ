package BOJ.practice_april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ9375 {
    static int testcase;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        testcase = Integer.parseInt(br.readLine());
        for(int i = 0;i<testcase;i++){
            int item = Integer.parseInt(br.readLine());
            HashMap<String,Integer> costume = new HashMap<>();
            for(int j = 0;j<item;j++){
                StringTokenizer stz = new StringTokenizer(br.readLine());
                stz.nextToken();
                String value = stz.nextToken();
                if(costume.containsKey(value)){
                    costume.put(value,costume.get(value)+1);
                }else{
                    costume.put(value,1);
                }
            }
            int result = 1;
            for(int k: costume.values()){
                result = result*(k+1);
            }
            sb.append(result-1+"\n");
        }
        System.out.println(sb);
    }
}
