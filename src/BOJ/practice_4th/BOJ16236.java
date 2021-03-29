package BOJ.practice_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16236 {
    static int n, babyx, babyy, time, result;
    static int[][] board;
    static int[] babyshark, dy, dx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        result = 0;
        dy = new int[]{-1, 0, 0, 1};//북 서 동 남
        dx = new int[]{0, -1, 1, 0};//북 서 동 남
        babyshark = new int[]{2, 0};
        time = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
                if (board[i][j] == 9) {
                    babyx = j;
                    babyy = i;
                }
            }
        }
        PriorityQueue<Point> q = new PriorityQueue<>();
        PriorityQueue<Point> nextq = new PriorityQueue<>();
        q.add(new Point(babyx, babyy));
        board[babyy][babyx] = 0;
        boolean[][] visited = new boolean[n][n];
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                Point nowloc = q.poll();
                int nowx = nowloc.x;
                int nowy = nowloc.y;
                if (board[nowy][nowx] < babyshark[0] && 0 != board[nowy][nowx]) {
                    q.clear();
                    nextq.clear();
                    size = 1;
                    babyshark[1]++;
                    result = time;
                    if (babyshark[0] == babyshark[1]) {
                        babyshark[0]++;
                        babyshark[1] = 0;
                    }
                    board[nowy][nowx] = 0;
                    for (int i = 0; i < n; i++)
                        Arrays.fill(visited[i], false);
                }
                visited[nowy][nowx] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = nowx + dx[i];
                    int ny = nowy + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (board[ny][nx] <= babyshark[0] && !visited[ny][nx]) {
                            visited[ny][nx] = true;
                            nextq.add(new Point(nx, ny));
                        }
                    }
                }
            }
            time++;
            if(q.isEmpty()){
                while(!nextq.isEmpty()){
                    q.add(nextq.poll());
                }
            }
        }
        System.out.println(result);
    }

}
class Point implements Comparable<Point>{

    public int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if(p.y==this.y)
            return this.x > p.x?1:-1;
        else
            return this.y > p.y?1:-1;
    }
}