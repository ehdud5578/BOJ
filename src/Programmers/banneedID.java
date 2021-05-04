package Programmers;

import java.util.*;

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
        public Set<Set<String>> result;
        public int solution(String[] user_id, String[] banned_id) {
            result = new HashSet<>();
            dfs(user_id,banned_id,new LinkedHashSet<>());
            return result.size();
        }
        public void dfs(String[] user_id,String[] banned_id,Set<String> set){
            if(set.size()==banned_id.length){
                if(isbanneduser(banned_id,set)){
                    result.add(new HashSet<>(set));
                }
            }
            for(String user:user_id){
                if(!set.contains(user)){
                    set.add(user);
                    dfs(user_id,banned_id,set);
                    set.remove(user);
                }
            }
        }
        public boolean isbanneduser(String[] banned_id,Set<String> set){
            if(banned_id.length!= set.size())
                return false;
            int i = 0;
            for(String user:set){
                if(!samestring(user,banned_id[i++])){
                    return false;
                }
            }
            return true;
        }
        public boolean samestring(String user, String banid){
            if(user.length()!=banid.length())
                return false;
            for(int i = 0;i<user.length();i++){
                if(banid.charAt(i)=='*'){
                    continue;
                }
                if(user.charAt(i)!=banid.charAt(i))
                    return false;
            }
            return true;
        }
    }

}
// 실패함
// 5.4 어떤 엄청 잘하시는분의 블로그 참조.https://bcp0109.tistory.com/186?category=885291
/*
* 앞으로 이사람 브로그를 많이 봐야겠다. 코드가 너무 깔끔하고 완전 내스타일이다.. 미쳤다 너무잘한다.
* */
/*static class Solution {
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
    */