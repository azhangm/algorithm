package SearchAndGraphTheory.DFS;

import java.util.*;
public class Nhou {
    /*
    *
    * 错误版本 数数字是对的
    * */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0 ; i < 11 ; i ++){
            for (int j = 0 ; j < 11 ; j ++)
                g[i][j] = '.';
        }
        dfs(0,n);
    }
    /**
     *
     * @param n int整型 the n
     * @return int整型
     */
    private static char[][] g = new char[20][20];
    private  static int count = 0;
    private static boolean[] col = new boolean[20];
    private static boolean[] dg = new boolean[20];
    private static boolean[] udg = new boolean[20];
    public int Nqueen (int n) {
        // write code here
        dfs(0,n);
        return count;
    }
    private static void dfs(int u, int n ){
        if (u == n){
            for (int i = 0 ; i < n ; i ++) {
                System.out.print(g[i] + " ");
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0 ;i < n ; i ++){
            if (!col[i] && !dg[u + i] && !udg[i - u + n]) // 这一列没放过 对角线没放过
            {
                g[u][i] = 'q' ;
                col[i] = dg[u + i] = udg[i - u + n] =true;
                dfs(u + 1,n);
                col[i] = dg[u + i] = udg[i - u + n] =false;
            }
        }

    }
}