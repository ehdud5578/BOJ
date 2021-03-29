package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17825 {
    static int[][] point, hors;
    static int[][][] direction, direction2;
    static int[] dice;

    public static void main(String[] args)throws Exception{
        point = new int[][]{
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
                {{1, 0}, {}, {}, {}, {0,-1}, {}, {}, {}, {}},
                {{1, 0}, {}, {}, {}, {-1, 0}, {-1, -1}, {0, -1}, {}, {}},
                {{1, 0}, {}, {}, {}, {-1, 0}, {}, {}, {-1, -1}, {}},
                {{1, 0}, {}, {}, {}, {-1, 0}, {}, {}, {}, {-1, 0}},
                {{1, 0}, {0, 1}, {0, 1}, {0, 1}, {-1, 0}, {0, -1}, {0, -1}, {0, -1}, {-1, 0}},
                {{1, 1}, {}, {}, {}, {-1, 0}, {}, {}, {}, {-1, 0}},
                {{}, {1, 1}, {}, {}, {-1, 0}, {}, {}, {-1, 1}, {}},
                {{}, {}, {0, 1}, {0, 1}, {0, 1}, {0, 1}, {0, 1}, {}, {}},
        };
        direction2 = new int[][][]{
                {{1, 0}, {}, {}, {}, {}, {}, {}, {}, {}},
                {{1, 0}, {}, {}, {}, {-1, 0}, {-1, -1}, {0, -1}, {}, {}},
                {{1, 0}, {}, {}, {}, {-1, 0}, {}, {}, {-1, -1}, {}},
                {{1, 0}, {}, {}, {}, {-1, 0}, {}, {}, {}, {-1, 0}},
                {{0, 1}, {0, 1}, {0, 1}, {0, 1}, {-1, 0}, {0, -1}, {0, -1}, {0, -1}, {0, -1}},
                {{1, 1}, {}, {}, {}, {-1, 0}, {}, {}, {}, {-1, 0}},
                {{}, {1, 1}, {}, {}, {-1, 0}, {}, {}, {-1, 1}, {}},
                {{}, {}, {0, 1}, {0, 1}, {-1, 0}, {0, 1}, {0, 1}, {}, {}},
        };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        hors = new int[][]{
                {0,0},
                {0,0},
                {0,0},
                {0,0}
        };
        dice = new int[10];
        StringTokenizer stz = new StringTokenizer(br.readLine());
        for(int i = 0;i<10;i++){
            dice[i] = Integer.parseInt(stz.nextToken());
        }
        dfs(0,0);
    }
    public static void dfs(int v,int sum){
        if(v==10){
            return;
        }
    }
}
