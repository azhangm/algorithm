package SearchAndGraphTheory.DFS;

import java.util.Scanner;

/*
 * 递归实现 排列型枚举
 * */
public class Arrange {
    private static Scanner sc = new Scanner(System.in);
    private static int[] path = new int[8];
    private static int n  = sc.nextInt();
    private static boolean st[] = new boolean[8];
    private static void dfs(int u){
        if (u == n){
            for (int i = 0;i < n ; i ++) System.out.print(path[i] + " ");
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i ++ ){
            if (! st[i]){
                path[u] = i;
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        dfs(0);
    }
}
