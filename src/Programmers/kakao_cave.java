package Programmers;

import javax.management.QueryEval;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class kakao_cave {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] path = new int[8][2];
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(stz.nextToken());
            int v2 = Integer.parseInt(stz.nextToken());
            path[i][0] = v1;
            path[i][1] = v2;
        }
        int[][] order = new int[][]{
                {4, 1}, {8, 7},{6,5}
        };
        Solution sol = new Solution();
        boolean result = sol.solution(n, path, order);
        if(result)
            bw.write("true");
        else
            bw.write("false");
        bw.flush();
    }

    static class Solution {
        static ArrayList<Integer>[] map;
        static boolean[] visited;
        static int[] before,after;
        public boolean solution(int n, int[][] path, int[][] order) {
            boolean answer = true;
            map = new ArrayList[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                map[i] = new ArrayList<>();
            }
            before = new int[n];
            after = new int[n];
            for(int i = 0;i<order.length;i++){
                before[order[i][1]] = order[i][0];
            }
            for (int i = 0; i < path.length; i++) {
                map[path[i][0]].add(path[i][1]);
                map[path[i][1]].add(path[i][0]);
            }
            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            visited[0] = true;
            if(before[0]!=0)
                return false;
            stack.addAll(map[0]);
            while (!stack.isEmpty()){
                int nown = stack.pop();
                if(visited[nown])
                    continue;
                if(!visited[before[nown]]){
                    after[before[nown]] = nown;
                    continue;
                }
                visited[nown] = true;
                stack.addAll(map[nown]);
                stack.add(after[nown]);
            }
            for(int i = 0;i<n;i++){
                if(!visited[i])
                    return false;
            }
            return answer;
        }
    }
}
