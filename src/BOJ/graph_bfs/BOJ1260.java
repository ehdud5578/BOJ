package BOJ.graph_bfs;
import java.io.*;
import java.util.*;

public class BOJ1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] r = input.split(" ");
        int n = Integer.parseInt(r[0]);
        int m = Integer.parseInt(r[1]);
        int v = Integer.parseInt(r[2]);
        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
        boolean[] c = new boolean[n+1];
        for(int i= 0;i<=n;i++){
            a[i] = new ArrayList<>();
        }

        for(int i = 0;i<m;i++){
            String input1 = br.readLine();
            String[] inputsplit = input1.split(" ");
            int v1 = Integer.parseInt(inputsplit[0]);
            int v2 = Integer.parseInt(inputsplit[1]);

            a[v1].add(v2);
            a[v2].add(v1);
        }
        for(int i = 0;i<=n;i++){
            Collections.sort(a[i]);
        }
        dfs(a,c,v);
        bw.write("\n");
        Arrays.fill(c,false);
        bfs(a,c,v);


        bw.flush();
    }

    public static void dfs(ArrayList<Integer>[] a, boolean[] c, int v) throws IOException {
        if(c[v]){
            return;
        }

        c[v] = true;
        bw.write(v+" ");
        for(int vv:a[v]){
            if(!c[vv]){
                dfs(a,c,vv);
            }
        }
    }
    public static void bfs(ArrayList<Integer>[] a, boolean[] c, int v) throws IOException {
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        c[v] = true;

        while(!q.isEmpty()){
            v = q.poll();
            bw.write(v + " ");
            for(int vv:a[v]){
                if(!c[vv]){
                    q.add(vv);
                    c[vv] = true;
                }
            }
        }
    }
}
