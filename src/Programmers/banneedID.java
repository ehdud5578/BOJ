package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class banneedID {
    public static void main(String[] args) {
        int n = new Solution().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"});
        System.out.println(n + " ");
        int n1 = new Solution().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"});
        System.out.println(n1 + " ");
        int n2 = new Solution().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"});
        System.out.println(n2 + " ");
    }

    static class Solution {
        public static Set<Set<String>> resultset;
        public static String[] user_id, banned_id;

        public int solution(String[] user_id, String[] banned_id) {
            Solution.banned_id = banned_id;
            Solution.user_id = user_id;
            resultset = new HashSet<>();
            dfs(0, new ArrayList<>(), new boolean[user_id.length]);
            return resultset.size();
        }

        public static void dfs(int v, ArrayList<Integer> s, boolean[] avisited) {
            if (v >= banned_id.length) {
                HashSet result = new HashSet(s);
                resultset.add(result);
                return;
            }
            String[] bannedsplit = banned_id[v].split("");
            for (int i = 0; i < user_id.length; i++) {
                if (avisited[i])
                    continue;
                ArrayList<Integer> nexts = new ArrayList<>(s);
                boolean[] visited = new boolean[user_id.length];
                System.arraycopy(avisited, 0, visited, 0, visited.length);
                String[] usersplit = user_id[i].split("");
                if (bannedsplit.length == usersplit.length) {
                    boolean ismatch = true;
                    for (int j = 0; j < banned_id.length; j++) {
                        if (bannedsplit[j].equals("*"))
                            continue;
                        if (!bannedsplit[j].equals(usersplit[j])) {
                            ismatch = false;
                            break;
                        }
                    }
                    if (ismatch) {
                        nexts.add(i);
                        visited[i] = true;
                        dfs(v + 1, nexts, visited);
                    }
                }
            }
        }
    }
}
// 실패함
