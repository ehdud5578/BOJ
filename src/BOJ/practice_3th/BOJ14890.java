package BOJ.practice_3th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14890 {
    static int n,l,result = 0;
    static int[][] board;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        l = Integer.parseInt(stz.nextToken());
        board = new int[n][n];
        for(int i = 0;i<n;i++){
            stz = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                board[i][j]  = Integer.parseInt(stz.nextToken());
            }
        }
        boolean[] check = new boolean[n];
        ww:for(int i = 0;i<n;i++){
            Arrays.fill(check,false);
            qq:for(int j = 0;j<n-1;j++){
                int now = board[i][j];
                int next = board[i][j+1];
                if(now==next)
                    continue qq;
                else if(now+1==next){
                    if(j<l-1)
                        continue ww;
                    for(int k = 0;k<l;k++){
                        if(board[i][j]==board[i][j-k]){
                            if(!check[j-k])
                                check[j-k] = true;
                            else
                                continue ww;
                        }
                        else
                            continue ww;
                    }
                } else if(now-1==next){
                    if(l+j>=n)
                        continue ww;
                    for(int k = 1;k<=l;k++){
                        if(next==board[i][j+k]){
                            if(!check[j+k])
                                check[j+k] = true;
                            else
                                continue ww;
                        }
                        else
                            continue ww;
                    }
                    j = j+l-1;
                } else
                    continue ww;
            }
            result++;
        }
        ww:for(int j = 0;j<n;j++){
            Arrays.fill(check,false);
            qq:for(int i = 0;i<n-1;i++){
                int now = board[i][j];
                int next = board[i+1][j];
                if(now==next)
                    continue qq;
                else if(now+1==next){
                    if(i<l-1)
                        continue ww;
                    for(int k = 0;k<l;k++){
                        if(board[i][j]==board[i-k][j]){
                            if(!check[i-k])
                                check[i-k] = true;
                            else
                                continue ww;
                        }
                        else
                            continue ww;
                    }
                } else if(now-1==next){
                    if(l+i>=n)
                        continue ww;
                    for(int k = 1;k<=l;k++){
                        if(next==board[i+k][j]){
                            if(!check[i+k])
                                check[i+k] = true;
                            else
                                continue ww;
                        }
                        else
                            continue ww;
                    }
                    i = i+l-1;
                } else
                    continue ww;
            }
            result++;
        }
        System.out.println(result);
    }
}
/*
qq:for(int k = 0;k<n-1;k++){
                int now = board[i][k];
                int next = board[i][k+1];
                if (now == next)
                    continue qq;
                else if (now + 1 == next) {
                    if(k<l)
                        continue ww;
                    for(int e = 0;e<l;e++){
                        if(board[i][k]!=board[i][k-e])
                            continue ww;
                        if(!check[k-e])
                            check[k-e] = true;
                        else continue ww;
                    }
                }
                else if(now-1==next){
                    if(k+l>n)
                        break;
                    for(int e = 1;e<=l;e++){
                        if(board[i][k]!=board[i][k+e])
                            continue ww;
                        if(!check[k+e])
                            check[k+e] = true;
                        else continue ww;
                    }
                }
                else break;
            }
            result++;
 */