package SearchAndGraphTheory.DFS;

import java.util.Scanner;
/*
* 二刷正确版本
*
* */
public class Nhou1 {
    //    存放皇后的数组  下标代表皇后位置
    private char g[][] = new char[20][20];
    //    按行 枚举 ，每行的元素不可能是重复的
    private boolean rol[] = new boolean[20];
    private boolean dg[] = new boolean[20];
    private boolean udg[] = new boolean[20];
    private int n = new Scanner(System.in).nextInt();
    private void dfs(int u){
        if (u == n) {
            for (int i = 0 ; i < n ; i ++){
                for (int j = 0; j < n; j++) {
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
            System.out.println();

            return;
        }
        for (int i = 0 ; i < n ; i ++){
            if (!rol[i] && !dg[i + u] && !udg[i - u + n]){
                // u 代表第几层 i 代表第几列
                g[u][i] = 'Q';
                rol[i] = dg[i + u] = udg[i - u + n] = true;
                dfs(u + 1);
                rol[i] = dg[i + u] = udg[i - u + n] = false;
                g[u][i] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Nhou1 nhou1 = new Nhou1();
        for (int i = 0; i < nhou1.n ; i++) {
            for (int j = 0; j < nhou1.n; j++) {
                nhou1.g[i][j] = '.';
            }
        }
        nhou1.dfs(0);
    }
}
