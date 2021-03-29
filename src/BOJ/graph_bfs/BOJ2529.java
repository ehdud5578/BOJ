package BOJ.graph_bfs;

import java.io.*;
import java.util.ArrayList;

public class BOJ2529 {
    static boolean[] visited;
    static int n;
    static ArrayList<String> array;
    static String[] calc;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        calc = br.readLine().split(" ");
        visited = new boolean[10];
        array = new ArrayList<String>();
        for(int i = 0;i<10;i++){
            visited[i] = true;
            dfs(i,0,i+"");
        }
        System.out.println(array.get(array.size() - 1));
        System.out.println(array.get(0));

    }
    public static void dfs(int v,int cnt,String str){
        if(cnt==n){
            array.add(str);
        }else{
            for(int i = 0;i<10;i++){
                if(!visited[i]){
                    if(calc[cnt].equals("<")){
                        if(v>=i)
                            continue;
                    }else{
                        if(v<=i)
                            continue;
                    }
                    visited[i] = true;
                    dfs(i,cnt+1,str+i);
                }
            }
        }
        visited[v] = false;
    }
}
/*
for(int i = 0;i<temp.length;i++){
        if(temp[i].equals("<")){
        deep[i+1] = deep[i]+1;
        }
        else{
        deep[i+1] = deep[i]-1;
        }
        }
        int[] maxresult = new int[n+1];
        int[] minersult = new int[n+1];
        int maxnum = 9;
        int munnum = 0;
        for(int i = 9;i>-9;i--){
        for(int j = 0;j<n+1;j++) {
        if (deep[j] == i) {
        maxresult[j] = maxnum;
        maxnum--;
        }
        }
        }
        for(int i = -9;i<9;i++){
        for(int j = 0;j<n+1;j++){
        if(deep[j]==i){
        minersult[j] = munnum;
        munnum++;
        }
        }
        }

*/

/*
*
*         maxnum[0] = 9;
        for(int i = 0;i<temp.length;i++){
            if(temp[i].equals("<")){
                deep[i+1] = deep[i]+1;
                for(int j = 0;j<=i;j++){
                    maxnum[j]--;
                }
                maxnum[i+1] = maxnum[i]++;
            }
            else{
                for(int j = 0;j<=i;j++){
                    deep[j]++;
                }
                maxnum[i+1] = maxnum[i]-1;
            }
        }
*
*
*/