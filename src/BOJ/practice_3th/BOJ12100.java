package BOJ.practice_3th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12100 {
    static int n, result;
    static int[][] board;
    static int[] dy, dx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dy = new int[]{0, 1, 0, -1};
        dx = new int[]{1, 0, -1, 0};
        for (int i = 0; i < n; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        for (int i = 0; i < 4; i++) {
            dfs(board, i, 0);
        }
        System.out.println(result);
    }

    public static int[][] cal(int[][] thisboard, int direction) {// dir 0~3 동 남 서 북
        int[][] nextboard = new int[n][n];
        boolean[][] check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(thisboard[i], 0, nextboard[i], 0, n);
        }
        switch (direction) {
            case 0: // 동
                for (int y = n - 1; y >= 0; y--) {
                    for (int x = n - 1; x > 0; x--) {
                        int now;
                        if (nextboard[y][x] == 0)
                            continue;
                        else {
                            now = nextboard[y][x];
                        }
                        int z = x - 1;
                        int next;
                        while (true) {
                            if (nextboard[y][z] != 0 || z == 0) {
                                next = nextboard[y][z];
                                break;
                            }
                            z--;
                        }
                        if (now == next) {
                            nextboard[y][x] = 2 * nextboard[y][x];
                            nextboard[y][z] = 0;
                        }
                    }
                }
                for (int y = n - 1; y >= 0; y--) {
                    for (int x = n - 1; x > 0; x--) {
                        if (nextboard[y][x] != 0)
                            continue;
                        int z = x - 1;
                        while (true) {
                            if (nextboard[y][z] != 0 || z == 0) {
                                nextboard[y][x] = nextboard[y][z];
                                nextboard[y][z] = 0;
                                break;
                            }
                            z--;
                        }
                    }
                }
                break;
            case 1: // 남
                for (int y = n - 1; y > 0; y--) {
                    for (int x = n - 1; x >= 0; x--) {
                        int now;
                        if (nextboard[y][x] == 0)
                            continue;
                        else {
                            now = nextboard[y][x];
                        }
                        int z = y - 1;
                        int next;
                        while (true) {
                            if (nextboard[z][x] != 0 || z == 0) {
                                next = nextboard[z][x];
                                break;
                            }
                            z--;
                        }
                        if (now == next) {
                            nextboard[y][x] = 2 * nextboard[y][x];
                            nextboard[z][x] = 0;
                        }
                    }
                }
                for (int y = n - 1; y > 0; y--) {
                    for (int x = n - 1; x >= 0; x--) {
                        if (nextboard[y][x] != 0)
                            continue;
                        int z = y - 1;
                        while (true) {
                            if (nextboard[z][x] != 0 || z == 0) {
                                nextboard[y][x] = nextboard[z][x];
                                nextboard[z][x] = 0;
                                break;
                            }
                            z--;
                        }
                    }
                }
                break;
            case 2: // 서
                for (int y = 0; y < n ; y++) {
                    for (int x = 0; x < n-1; x++) {
                        int now;
                        if (nextboard[y][x] == 0)
                            continue;
                        else {
                            now = nextboard[y][x];
                        }
                        int z = x + 1;
                        int next;
                        while (true) {
                            if (nextboard[y][z] != 0 || z == n - 1) {
                                next = nextboard[y][z];
                                break;
                            }
                            z++;
                        }
                        if (now == next) {
                            nextboard[y][x] = 2 * nextboard[y][x];
                            nextboard[y][z] = 0;
                        }
                    }
                }
                for (int y = 0; y < n ; y++) {
                    for (int x = 0; x < n-1; x++) {
                        if (nextboard[y][x] != 0)
                            continue;
                        int z = x + 1;
                        while (true) {
                            if (nextboard[y][z] != 0 || z == n - 1) {
                                nextboard[y][x] = nextboard[y][z];
                                nextboard[y][z] = 0;
                                break;
                            }
                            z++;
                        }
                    }
                }
                break;
            case 3: // 북
                for (int y = 0; y < n-1; y++) {
                    for (int x = 0; x < n; x++) {
                        int now;
                        if (nextboard[y][x] == 0)
                            continue;
                        else {
                            now = nextboard[y][x];
                        }
                        int z = y + 1;
                        int next;
                        while (true) {
                            if (nextboard[z][x] != 0 || z == n-1) {
                                next = nextboard[z][x];
                                break;
                            }
                            z++;
                        }
                        if (now == next) {
                            nextboard[y][x] = 2 * nextboard[y][x];
                            nextboard[z][x] = 0;
                        }
                    }
                }
                for (int y = 0; y < n-1; y++) {
                    for (int x = 0; x < n; x++) {
                        if (nextboard[y][x] != 0)
                            continue;
                        int z = y + 1;
                        while (true) {
                            if (nextboard[z][x] != 0 || z == n-1) {
                                nextboard[y][x] = nextboard[z][x];
                                nextboard[z][x] = 0;
                                break;
                            }
                            z++;
                        }
                    }
                }
                break;
        }
        return nextboard;
    }

    public static void dfs(int[][] rboard, int dir, int deep) {// dir 0~3 동 남 서 북
        if (deep == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    result = Math.max(rboard[i][j], result);
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            dfs(cal(rboard, dir), i, deep + 1);
        }
    }
}
