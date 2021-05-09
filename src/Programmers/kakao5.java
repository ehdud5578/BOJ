package Programmers;

public class kakao5 {
    public static void main(String[] args) {
        int result = new Solution().solution(3, new int[]{12, 30, 1, 8, 8, 6, 20, 7, 5, 10, 4, 1},
                new int[][]{{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {8, 5}, {2, 10}, {3, 0}, {6, 1}, {11, -1}, {7, 4}, {-1, -1}, {-1, -1}});
        System.out.println(result);
    }

    static class Solution {
        public static int answer,k;
        public static int[] num,root;
        public int solution(int k, int[] num, int[][] links) {
            root = new int[k];

            boolean[] iscalled = new boolean[num.length];
            for (int[] link : links) {
                for (int j = 0; j < 2; j++) {
                    if(link[j]==-1)
                        continue;
                    iscalled[link[j]] = true;
                }
            }
            for(int i = 0;i<num.length;i++){
                if(!iscalled[i]){
                    root[0] = i;
                }
            }
            Solution.k = k;
            Solution.num = num;
            answer = Integer.MAX_VALUE;
            dfs(k - 1, links);
            return answer;
        }

        public static void dfs(int v, int[][] links) {
            if (v == 0) {
                answer = Math.min(answer,sumlink(links));
                return;
            }
            for (int i = 0; i < links.length; i++) {
                for (int j = 0; j < 2; j++) {
                    if (links[i][j] != -1) {
                        int temp = links[i][j];
                        links[i][j] = -1;
                        root[v] = temp;
                        dfs(v - 1, links);
                        links[i][j] = temp;
                    }
                }
            }
        }

        public static int sumlink(int[][] links) {
            int[] thisnum = new int[num.length];
            System.arraycopy(num, 0, thisnum, 0, num.length);
            for (int i :root) {
                thisnum[i] = sumchild(i, links);
            }
            int max = 0;
            for(int i:root){
                max = Math.max(thisnum[i],max);
            }
            return max;
        }
        public static int sumchild(int i, int[][] links) {
            int left = links[i][0];
            int right = links[i][1];
            if (left == -1 && right == -1) {
                return num[i];
            } else if (right != -1 && left != -1) {
                return num[i] + sumchild(left, links) + sumchild(right, links);
            } else if (right != -1) {
                return num[i] +sumchild(right, links);
            } else {  // links[i][1]==-1&&links[i][0]!=-1
                return num[i] +sumchild(left, links);
            }
        }
    }
}
