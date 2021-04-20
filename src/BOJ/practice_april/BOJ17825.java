package BOJ.practice_april;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17825 {
    static int[][] point;
    static int[][][] direction, direction2;
    static int[] dice;
    public static int result;
    public static void main(String[] args)throws Exception{
        point = new int[][]{
                {0, -1, -1, -2, -2, -1, -1, -1, -1},
                {2, -1, -1, -2, 0, -1, -1, -1, -1},
                {4, -1, -1, -1, 40, 38, 36, -1, -1},
                {6, -1, -1, -1, 35, -1, -1, 34, -1},
                {8, -1, -1, -1, 30, -1, -1, -1, 32},
                {10, 13, 16, 19, 25, 26, 27, 28, 30},
                {12, -1, -1, -1, 24, -1, -1, -1, 28},
                {-1, 14, -1, -1, 22, -1, -1, 26, -1},
                {-1, -1, 16, 18, 20, 22, 24, -1, -1},
        };
        direction = new int[][][]{
                {{1, 0}, {}, {}, {}, {0,0}, {}, {}, {}, {}},
                {{1, 0}, {}, {}, {}, {0,0}, {}, {}, {}, {}},
                {{1, 0}, {}, {}, {}, {-1, 0}, {0, -1}, {0, -1}, {}, {}},
                {{1, 0}, {}, {}, {}, {-1, 0}, {}, {}, {-1, -1}, {}},
                {{1, 0}, {}, {}, {}, {-1, 0}, {}, {}, {}, {-1, -1}},
                {{1, 0}, {0, 1}, {0, 1}, {0, 1}, {-1, 0}, {0, -1}, {0, -1}, {0, -1}, {-1, 0}},
                {{1, 1}, {}, {}, {}, {-1, 0}, {}, {}, {}, {-1, 0}},
                {{}, {1, 1}, {}, {}, {-1, 0}, {}, {}, {-1, 1}, {}},
                {{}, {}, {0, 1}, {0, 1}, {0, 1}, {0, 1}, {-1, 1}, {}, {}},
        };
        direction2 = new int[][][]{
                {{1, 0}, {}, {}, {}, {0,0}, {}, {}, {}, {}},
                {{1, 0}, {}, {}, {}, {-1,0}, {}, {}, {}, {}},
                {{1, 0}, {}, {}, {}, {-1, 0}, {0, -1}, {0, -1}, {}, {}},
                {{1, 0}, {}, {}, {}, {-1, 0}, {}, {}, {-1, -1}, {}},
                {{1, 0}, {}, {}, {}, {-1, 0}, {}, {}, {}, {-1, -1}},
                {{0, 1}, {0, 1}, {0, 1}, {0, 1}, {-1, 0}, {0, -1}, {0, -1}, {0, -1}, {0, -1}},
                {{1, 1}, {}, {}, {}, {-1, 0}, {}, {}, {}, {-1, 0}},
                {{}, {1, 1}, {}, {}, {-1, 0}, {}, {}, {-1, 1}, {}},
                {{}, {}, {0, 1}, {0, 1}, {-1, 0}, {0, 1}, {-1, 1}, {}, {}},
        };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] hors = new int[][]{
                {0,0},
                {0,0},
                {0,0},
                {0,0}
        };
        dice = new int[10];
        result = 0;
        StringTokenizer stz = new StringTokenizer(br.readLine());
        for(int i = 0;i<10;i++){
            dice[i] = Integer.parseInt(stz.nextToken());
        }
        dfs(0,0,hors);
        System.out.println(result);
    }
    public static void dfs(int v,int sum,int[][] qhors){
        if(v==10){
            result = Math.max(result,sum);
            return;
        }
        for(int i = 0;i<4;i++){
            int[][] hors = new int[4][2];
            for(int k = 0;k<4;k++){
                hors[k][0] = qhors[k][0];
                hors[k][1] = qhors[k][1];
            }
            int[] nextpoint;
            if(hors[i][0]==1&&hors[i][1]==4)
                continue;
            if((hors[i][0]==5&&hors[i][1]==0)||(hors[i][0]==5&&hors[i][1]==8)||(hors[i][0]==8&&hors[i][1]==4)){
                int[] nexthors = new int[2];
                nexthors[0] = hors[i][0] + direction2[hors[i][0]][hors[i][1]][0];
                nexthors[1] = hors[i][1] + direction2[hors[i][0]][hors[i][1]][1];
                nextpoint = horsemove(nexthors,dice[v]-1);
            }else{
                nextpoint = horsemove(hors[i],dice[v]);
            }
            boolean isredunduncy = false;
            for(int k = 0;k<4;k++){
                if(k==i)
                    continue;
                if(hors[k][0]==nextpoint[0]&&hors[k][1]==nextpoint[1])
                    isredunduncy = true;
            }
            if(isredunduncy){
                if(nextpoint[0]==1&&nextpoint[1]==4)
                    isredunduncy = false;
            }
            if(isredunduncy)
                continue;
            hors[i][0] = nextpoint[0];
            hors[i][1] = nextpoint[1];
            dfs(v+1,sum+point[nextpoint[0]][nextpoint[1]],hors);
        }
    }
    public static int[] horsemove(int[] hors,int n){
        if(n==0)
            return hors;
        int[] nexthors = new int[2];
        nexthors[0] = hors[0] + direction[hors[0]][hors[1]][0];
        nexthors[1] = hors[1] + direction[hors[0]][hors[1]][1];
        return horsemove(nexthors,n-1);
    }
}
// 인간승리 개오래걸림 ㅠ