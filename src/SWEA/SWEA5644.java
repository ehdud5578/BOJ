package SWEA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA5644 {
    static int alocx, alocy, blocx, blocy, charge, m, a;
    static int[] dira, dirb, dy, dx;
    static BC[] bcs;
    static boolean[][] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        dy = new int[]{0, -1, 0, 1, 0};
        dx = new int[]{0, 0, 1, 0, -1};
        for (int i = 1; i <= testcase; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            m = Integer.parseInt(stz.nextToken());
            a = Integer.parseInt(stz.nextToken());
            bcs = new BC[a];
            path = new boolean[2][a];
            dira = new int[m + 1];
            dirb = new int[m + 1];
            stz = new StringTokenizer(br.readLine());
            StringTokenizer stzb = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                dira[j] = Integer.parseInt(stz.nextToken());
                dirb[j] = Integer.parseInt(stzb.nextToken());
            }
            for (int k = 0; k < a; k++) {
                stz = new StringTokenizer(br.readLine());
                int kx = Integer.parseInt(stz.nextToken());
                int ky = Integer.parseInt(stz.nextToken());
                int kc = Integer.parseInt(stz.nextToken());
                int kp = Integer.parseInt(stz.nextToken());
                bcs[k] = new BC(kx, ky, kc, kp);
            }
            charge = 0;
            alocx = alocy = 1;
            blocx = blocy = 10;
            for (int k = 0; k <= m; k++) {
                int nax = alocx + dx[dira[k]];
                int nay = alocy + dy[dira[k]];
                int nbx = blocx + dx[dirb[k]];
                int nby = blocy + dy[dirb[k]];
                Arrays.fill(path[0], false);
                Arrays.fill(path[1], false);
                for (int t = 0; t < a; t++) {
                    if (Math.abs(nax - bcs[t].x) + Math.abs(nay - bcs[t].y) <= bcs[t].c) {
                        path[0][t] = true;
                    }
                    if (Math.abs(nbx - bcs[t].x) + Math.abs(nby - bcs[t].y) <= bcs[t].c) {
                        path[1][t] = true;
                    }
                }
                charge = charge + getMax();
                alocx = nax;
                alocy = nay;
                blocx = nbx;
                blocy = nby;
            }
            bw.write("#" + i + " " + charge + "\n");
        }
        bw.flush();
    }

    static int getMax() {
        int max = 0;
        for (int j = 0; j < a; j++) {
            for (int e = 0; e < a; e++) {
                int temp = 0;
                if (path[0][j]) {
                    if (path[1][e]) {
                        temp = j == e ? bcs[e].p : bcs[e].p + bcs[j].p;
                    } else {
                        temp = bcs[j].p;
                    }
                } else {
                    if (path[1][e]) {
                        temp = bcs[e].p;
                    }
                }
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}

class BC {
    int x;
    int y;
    int c;
    int p;

    BC(int x, int y, int c, int p) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.p = p;
    }
}