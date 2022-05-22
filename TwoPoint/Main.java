package TwoPoint;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0 ; i < n ; i ++){
            a[i] = sc.nextInt();
        }
        for (int i = 0 ; i < n ; i ++){
            b[i] = sc.nextInt();
        }
        int i = 0;
        int j = 0;
        while (i < n && j < m){
            System.out.println(a[i] == b[j]);
            if (a[i] == b[j]) {
                i ++;}
            j ++;
        }

        if (i == n - 1) System.out.println("Yes");
        else System.out.println("No");
    }

}
