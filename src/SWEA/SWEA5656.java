package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5656 {
    static int testcase,result,n,w,h;
    static int[][] board;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        testcase = Integer.parseInt(br.readLine());
        for(int i = 1;i<=testcase;i++){
            result = 1100;
            StringTokenizer stz = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stz.nextToken());
            w = Integer.parseInt(stz.nextToken());
            h = Integer.parseInt(stz.nextToken());
            board = new int[h][w];
            for(int y = 0;y<h;y++){
                stz = new StringTokenizer(br.readLine());
                for(int x = 0;x<w;x++){
                    board[y][x] = Integer.parseInt(stz.nextToken());
                }
            }
            find(0,board);
            bw.write("#" + i + " " + result + "\n");
        }
        bw.flush();
    }
    public static void find(int ntime,int[][] aaboard){
        if(ntime==n){
            int thiscount = 0;
            for(int i = 0;i<h;i++){
                for(int j = 0;j<w;j++){
                    if(aaboard[i][j]==0)
                        continue;
                    thiscount++;
                }
            }
            result = Math.min(result,thiscount);
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int j = 0;j<w;j++){
            int[][] thisboard = new int[h][w];
            for(int iy = 0;iy<h;iy++){
                for(int jx = 0;jx<w;jx++){
                    thisboard[iy][jx] = aaboard[iy][jx];
                }
            }
            for(int i = 0;i<h;i++){
                if(thisboard[i][j]!=0){
                    queue.add(new int[]{i,j,thisboard[i][j]});
                    while (!queue.isEmpty()){
                        int[] now = queue.poll();
                        thisboard[now[0]][now[1]] = 0;
                        for(int range = 1;range<now[2];range++){
                            if(now[0]-range>=0&&thisboard[now[0]-range][now[1]]!=0){
                                queue.add(new int[]{now[0]-range,now[1],thisboard[now[0]-range][now[1]]});
                            }
                            if(now[0]+range<h&&thisboard[now[0]+range][now[1]]!=0){
                                queue.add(new int[]{now[0]+range,now[1],thisboard[now[0]+range][now[1]]});
                            }
                            if(now[1]+range<w&&thisboard[now[0]][now[1]+range]!=0){
                                queue.add(new int[]{now[0],now[1]+range,thisboard[now[0]][now[1]+range]});
                            }
                            if(now[1]-range>=0&&thisboard[now[0]][now[1]-range]!=0){
                                queue.add(new int[]{now[0],now[1]-range,thisboard[now[0]][now[1]-range]});
                            }
                        }
                    }
                    break;
                }
            }
            for(int y = h-1;y>0;y--){
                for(int x = 0;x<w;x++){
                    if(thisboard[y][x]==0){
                        int z = y;
                        while (true){
                            if(z==0||thisboard[z][x]!=0){
                                thisboard[y][x] = thisboard[z][x];
                                thisboard[z][x] = 0;
                                break;
                            }
                            z--;
                        }
                    }
                }
            }
            find(ntime+1,thisboard);
        }
    }
}
