package SearchAndGraphTheory.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {
    static class Pair{
        // 存储路径
        int x = 0;
        int y = 0;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    class Main{
        // 存储地图

        // 存 距离起点多少步

        // 存储路径
        private  static  Scanner scanner = new Scanner(System.in);
        private static int n = scanner.nextInt();
        private static int m = scanner.nextInt();
        private static int[][] map = new int[n][m];
        private static int[][] d = new int[n][m];
        private static Pair[][] pairs =  new Pair[n * m][n * m];
        private static  int i = 0;
        private static int bfs(){
            Scanner sc = new Scanner(System.in);
            map[0][0] = 0;
            map[0][1] = 1;
            map[0][2] = 0;
            map[0][3] = 0;
            map[0][4] = 0;
            map[1][0] = 0;
            map[1][1] = 1;
            map[1][2] = 0;
            map[1][3] = 1;
            map[1][4] = 0;
            map[2][0] = 0;
            map[2][1] = 0;
            map[2][2] = 0;
            map[2][3] = 0;
            map[2][4] = 0;
            map[3][0] = 0;
            map[3][1] = 1;
            map[3][2] = 1;
            map[3][3] = 1;
            map[3][4] = 0;
            map[4][0] = 0;
            map[4][1] = 0;
            map[4][2] = 0;
            map[4][3] = 1;
            map[4][4] = 0;
            Queue<Pair> queue = new LinkedList<>();
            int[] dx = {0,1,0,-1};
            int[] dy = {1,0,-1,0};
            // 上下左右
            // 存储起点
            queue.add(new Pair(0,0));
            while (!queue.isEmpty()){
                Pair p = queue.poll();
            // 判断上下左右
            for (int i = 0; i < 4 ; i ++) {
                // 当前点的上下左右
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (x >= 0 && x < n && y >=0 && y < n && map[x][y] == 0 && d[x][y] == 0){
                    d[x][y] = d[p.x][p.y] + 1;
                        queue.add(new Pair(x,y));
                        pairs[x][y] = new Pair(p.x, p.y);
                }
            }
            }
            int x = n - 1 , y = m - 1;
            while (x != 0 || y != 0){
                System.out.println(x + " " + y);
                Pair p = pairs[x][y];
                x = p.x;
                y = p.y;
            }
            return d[n-1][m-1];
        }
    }

    public static void main(String[] args) {
        int bfs = Main.bfs();
        System.out.println(bfs);
    }
}
