package BOJ.practice_april;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5373 {
    static int testcase;
    static char[][][] cube;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        testcase = Integer.parseInt(br.readLine());
        for(int test = 0;test<testcase;test++){
            int rotate = Integer.parseInt(br.readLine());
            char[][] command = new char[rotate][2];
            StringTokenizer stz = new StringTokenizer(br.readLine());
            for(int i = 0;i<rotate;i++){
                String thisCommand = stz.nextToken();
                command[i][0] = thisCommand.charAt(0);
                command[i][1] = thisCommand.charAt(1);
            }
            cube = new char[6][3][3];
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    cube[0][i][j] = 'w'; // 위
                    cube[1][i][j] = 'r'; // 앞면
                    cube[2][i][j] = 'y'; // 아래
                    cube[3][i][j] = 'o'; // 뒷면
                    cube[4][i][j] = 'g'; // 왼쪽
                    cube[5][i][j] = 'b'; // 오른쪽
                }
            }
            for(int i = 0;i<rotate;i++){
                switch (command[i][0]){
                    case 'U':
                        if(command[i][1]=='+'){
                            turnright(0);
                            for(int k = 0;k<3;k++){
                                char temp = cube[3][2][k];
                                cube[3][2][k] = cube[4][2-k][2];
                                cube[4][2-k][2] = cube[1][0][2-k];
                                cube[1][0][2-k] = cube[5][k][0];
                                cube[5][k][0] = temp;
                            }
                        }else{
                            turnleft(0);
                            for(int k = 0;k<3;k++){
                                char temp = cube[3][2][k];
                                cube[3][2][k] = cube[5][k][0];
                                cube[5][k][0] = cube[1][0][2-k];
                                cube[1][0][2-k] = cube[4][2-k][2];
                                cube[4][2-k][2] = temp;
                            }
                        }
                        break;
                    case 'D':
                        if (command[i][1]=='+'){
                            turnright(2);
                            for(int k = 0;k<3;k++){
                                char temp = cube[1][2][k];
                                cube[1][2][k] = cube[4][k][0];
                                cube[4][k][0] = cube[3][0][2-k];
                                cube[3][0][2-k] = cube[5][2-k][2];
                                cube[5][2-k][2] = temp;
                            }
                        }else {
                            turnleft(2);
                            for (int k = 0; k < 3; k++) {
                                char temp = cube[1][2][k];
                                cube[1][2][k] = cube[5][2 - k][2];
                                cube[5][2 - k][2] = cube[3][0][2 - k];
                                cube[3][0][2 - k] = cube[4][k][0];
                                cube[4][k][0] = temp;
                            }
                        }
                        break;
                    case 'L':
                        if (command[i][1]=='+'){
                            turnright(4);
                            for(int k = 0;k<3;k++){
                                char temp = cube[3][k][0];
                                cube[3][k][0] = cube[2][k][0];
                                cube[2][k][0] = cube[1][k][0];
                                cube[1][k][0] = cube[0][k][0];
                                cube[0][k][0] = temp;
                            }
                        }else {
                            turnleft(4);
                            for (int k = 0; k < 3; k++) {
                                char temp = cube[3][k][0];
                                cube[3][k][0] = cube[0][k][0];
                                cube[0][k][0] = cube[1][k][0];
                                cube[1][k][0] = cube[2][k][0];
                                cube[2][k][0] = temp;
                            }
                        }
                        break;
                    case 'R':
                        if (command[i][1]=='+'){
                            turnright(5);
                            for(int k = 0;k<3;k++){
                                char temp = cube[3][2-k][2];
                                cube[3][2-k][2] = cube[0][2-k][2];
                                cube[0][2-k][2] = cube[1][2-k][2];
                                cube[1][2-k][2] = cube[2][2-k][2];
                                cube[2][2-k][2] = temp;
                            }
                        }else {
                            turnleft(5);
                            for (int k = 0; k < 3; k++) {
                                char temp = cube[3][2 - k][2];
                                cube[3][2 - k][2] = cube[2][2 - k][2];
                                cube[2][2 - k][2] = cube[1][2 - k][2];
                                cube[1][2 - k][2] = cube[0][2 - k][2];
                                cube[0][2 - k][2] = temp;
                            }
                        }
                        break;
                    case 'B':
                        if (command[i][1]=='+'){
                            turnright(3);
                            for(int k = 0;k<3;k++){
                                char temp = cube[2][2][k];
                                cube[2][2][k] = cube[4][0][2-k];
                                cube[4][0][2-k] = cube[0][0][2-k];
                                cube[0][0][2-k] = cube[5][0][2-k];
                                cube[5][0][2-k] = temp;
                            }
                        }else {
                            turnleft(3);
                            for (int k = 0; k < 3; k++) {
                                char temp = cube[2][2][k];
                                cube[2][2][k] = cube[5][0][2-k];
                                cube[5][0][2-k]  = cube[0][0][2-k];
                                cube[0][0][2-k] = cube[4][0][2-k];
                                cube[4][0][2-k] = temp;
                            }
                        }
                        break;
                    case 'F':
                        if (command[i][1]=='+'){
                            turnright(1);
                            for(int k = 0;k<3;k++){
                                char temp = cube[0][2][k];
                                cube[0][2][k] = cube[4][2][k];
                                cube[4][2][k] = cube[2][0][2-k];
                                cube[2][0][2-k] = cube[5][2][k];
                                cube[5][2][k] = temp;
                            }
                        }else {
                            turnleft(1);
                            for (int k = 0; k < 3; k++) {
                                char temp = cube[0][2][k];
                                cube[0][2][k] = cube[5][2][k];
                                cube[5][2][k] = cube[2][0][2-k];
                                cube[2][0][2-k] = cube[4][2][k];
                                cube[4][2][k] = temp;
                            }
                        }
                        break;
                }
            }
            for(int i = 0;i<3;i++){
                for(int j = 0;j<3;j++){
                    bw.write(String.valueOf(cube[0][i][j]));
                }
                bw.write("\n");
            }
        }
        bw.flush();
    }
    public static void turnright(int center){
        char[][] temp = new char[3][3];
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                temp[i][j] = cube[center][i][j];
            }
        }
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                cube[center][i][j] = temp[2-j][i];
            }
        }
    }
    public static void turnleft(int center){
        char[][] temp = new char[3][3];
        for(int i = 0;i<3;i++){
            for(int j =0;j<3;j++){
                temp[i][j] = cube[center][i][j];
            }
        }
        for(int i = 0;i<3;i++){
            for(int j =0;j<3;j++){
                cube[center][i][j] = temp[j][2-i];
            }
        }
    }
}


/*
*
* public static char[][][] turnright(char[][][] cube,int center,int up,int down,int right,int left){
        char[][] copy = new char[3][3];
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                copy[i][j] = cube[center][i][j];
            }
        }
        cube[center][0][0] = copy[2][0];
        cube[center][0][1] = copy[1][0];
        cube[center][0][2] = copy[0][0];
        cube[center][1][0] = copy[2][1];
        cube[center][1][2] = copy[0][1];
        cube[center][2][0] = copy[2][2];
        cube[center][2][1] = copy[1][2];
        cube[center][2][2] = copy[0][2];
        char up1,up2,up3;
        up1 = cube[up][2][0];
        up2 = cube[up][2][1];
        up3 = cube[up][2][2];
        cube[up][2][0] = cube[left][0][2];
        cube[up][2][1] = cube[left][1][2];
        cube[up][2][2] = cube[left][2][2];
        cube[left][0][2] = cube[down][0][0];
        cube[left][1][2] = cube[down][0][1];
        cube[left][2][2] = cube[down][0][2];
        cube[down][0][0] = cube[right][2][0];
        cube[down][0][1] = cube[right][1][0];
        cube[down][0][2] = cube[right][0][0];
        cube[right][2][0] = up3;
        cube[right][1][0] = up2;
        cube[right][0][0] = up1;
        return cube;
    }
    public static char[][][] turnrleft(char[][][] cube,int center,int up,int down,int right,int left){
        char[][] copy = new char[3][3];
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                copy[i][j] = cube[center][i][j];
            }
        }
        cube[center][0][0] = copy[0][2];
        cube[center][0][1] = copy[1][2];
        cube[center][0][2] = copy[2][2];
        cube[center][1][0] = copy[0][1];
        cube[center][1][2] = copy[2][1];
        cube[center][2][0] = copy[0][0];
        cube[center][2][1] = copy[1][0];
        cube[center][2][2] = copy[2][0];
        char up1,up2,up3;
        up1 = cube[up][2][0];
        up2 = cube[up][2][1];
        up3 = cube[up][2][2];
        cube[up][2][0] = cube[right][0][0];
        cube[up][2][1] = cube[right][1][0];
        cube[up][2][2] = cube[right][2][0];
        cube[right][0][0] = cube[down][0][3];
        cube[right][1][0] = cube[down][0][2];
        cube[right][2][0] = cube[down][0][1];
        cube[down][0][3] = cube[left][2][2];
        cube[down][0][2] = cube[left][1][2];
        cube[down][0][1] = cube[left][0][2];
        cube[left][2][2] = up1;
        cube[left][1][2] = up2;
        cube[left][0][2] = up3;
        return cube;
    }
    * */