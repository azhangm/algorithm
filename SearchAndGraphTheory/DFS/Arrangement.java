package SearchAndGraphTheory.DFS;/*
* 递归实现 排列型枚举
* */

import java.util.Scanner;

public class Arrangement {
   static int[] path = new int[10];
   static int count = 1;
   static int[] s = new int[10]; // 表示第几个数字被用 1 表示 被使用 0 表示没有被使用
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(0,n);
    }

    private static void dfs(int u,int n) {
        if (u == n) {
            for (int i = 0 ; i < n ; i ++) System.out.print(path[i] + " ");
            System.out.println();
            return;
        }
            for (int i = 1 ; i <= n; i ++){
                if (s[i] == 0){   //没有被使用过
                    path[u] = i;
                    s[i] = 1;
                    dfs(u+1,n);
                    s[i] = 0; // 回溯
                }
            }
        }


    }


