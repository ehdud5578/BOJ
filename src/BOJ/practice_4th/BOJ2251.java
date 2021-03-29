package BOJ.practice_4th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b, c;
        StringTokenizer stz = new StringTokenizer(br.readLine());
        a = Integer.parseInt(stz.nextToken());
        b = Integer.parseInt(stz.nextToken());
        c = Integer.parseInt(stz.nextToken());
        boolean[][][] check = new boolean[a+1][b+1][c+1];
        int nowa = 0,nowb = 0, nowc = c;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{nowa,nowb,nowc});
        check[nowa][nowb][nowc] = true;
        PriorityQueue<Integer> resultset = new PriorityQueue<>();
        while(!q.isEmpty()){
            int[] thiscase = q.poll();
            int thisa = thiscase[0];
            int thisb = thiscase[1];
            int thisc = thiscase[2];
            if(thisa==0){
                if(!resultset.contains(thisc))
                    resultset.add(thisc);
            }
            if(thisa!=0){
                int nexta,nextb,nextc;
                if(thisb!=b){
                    nexta = thisa;
                    nextb = thisb;
                    nextc = thisc;
                    while(true){
                        nextb++;
                        nexta--;
                        if(nextb==b||nexta==0)
                            break;
                    }
                    if(!check[nexta][nextb][nextc]){
                        check[nexta][nextb][nextc] = true;
                        q.add(new int[]{nexta,nextb,nextc});
                    }
                }
                nexta = 0;
                nextb = thisb;
                nextc = thisc + thisa;
                if(!check[nexta][nextb][nextc]){
                    check[nexta][nextb][nextc] = true;
                    q.add(new int[]{nexta,nextb,nextc});
                }
            }
            if(thisb!=0){
                int nexta,nextb,nextc;
                if(thisa!=a){
                    nexta = thisa;
                    nextb = thisb;
                    nextc = thisc;
                    while(true){
                        nextb--;
                        nexta++;
                        if(nextb==0||nexta==a)
                            break;
                    }
                    if(!check[nexta][nextb][nextc]){
                        check[nexta][nextb][nextc] = true;
                        q.add(new int[]{nexta,nextb,nextc});
                    }
                }
                nexta = thisa;
                nextb = 0;
                nextc = thisc+thisb;
                if(!check[nexta][nextb][nextc]){
                    check[nexta][nextb][nextc] = true;
                    q.add(new int[]{nexta,nextb,nextc});
                }
            }
            if(thisc!=0){
                int nexta,nextb,nextc;
                if(thisa!=a){
                    nexta = thisa;
                    nextb = thisb;
                    nextc = thisc;
                    while(true){
                        nexta++;
                        nextc--;
                        if(nextc==0||nexta==a)
                            break;
                    }
                    if(!check[nexta][nextb][nextc]){
                        check[nexta][nextb][nextc] = true;
                        q.add(new int[]{nexta,nextb,nextc});
                    }
                }
                if(thisb!=b){
                    nexta = thisa;
                    nextb = thisb;
                    nextc = thisc;
                    while(true){
                        nextc--;
                        nextb++;
                        if(nextc==0||nextb==b)
                            break;
                    }
                    if(!check[nexta][nextb][nextc]){
                        check[nexta][nextb][nextc] = true;
                        q.add(new int[]{nexta,nextb,nextc});
                    }
                }
            }
        }
        while(!resultset.isEmpty())
            System.out.print(resultset.poll()+" ");

    }
}
/*
우선 순위 큐의 높이는 힙으로 구현되기 때문에 큐에 갯수랑 큐의 사이즈랑 다르다..이거때문에 오래걸림.
큐.size() 가 큐의 원소의 갯수랑 다름

 */
