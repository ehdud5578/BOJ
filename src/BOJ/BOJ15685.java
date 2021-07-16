package BOJ;

import java.io.*;

public class BOJ15685 {

    public static int g;
    public static int[] dy, dx, curve;
    public static boolean[][] dragon;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dy = new int[]{0, -1, 0, 1}; // 오 , 위 , 왼 , 아래
        dx = new int[]{1, 0, -1, 0}; // 오 , 위 , 왼 , 아래
        dragon = new boolean[101][101];
        curve = new int[1030];
        int n, x, y, d;
        n = Integer.parseInt(br.readLine());
        result = 0;
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            x = Integer.parseInt(temp[0]);
            y = Integer.parseInt(temp[1]);
            d = Integer.parseInt(temp[2]);
            g = Integer.parseInt(temp[3]);
            dragoncurve(y, x, d, 0);
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (dragon[i][j] && dragon[i + 1][j] && dragon[i][j + 1] && dragon[i + 1][j + 1])
                    result++;
            }
        }
        System.out.println(result);
    }

    public static void dragoncurve(int y, int x, int d, int nowg) {
        if (nowg == g + 1) {
            int ny = y;
            int nx = x;
            dragon[ny][nx] = true;
            for (int i = 0; i < (1 << g); i++) {
                nx = (nx + dx[curve[i]]);
                ny = (ny + dy[curve[i]]);
                if (!dragon[ny][nx])
                    dragon[ny][nx] = true;
            }
            return;
        }
        if (nowg == 0)
            curve[nowg] = d;
        else {
            for (int i = 0; i < (1 << nowg) / 2; i++) {
                curve[(1 << nowg) - 1 - i] = (curve[i] + 1) % 4;
            }
        }
        dragoncurve(y, x, d, nowg + 1);
    }

}
