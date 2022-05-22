package Week52;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] date = new int[n  + 1];
        for (int i = 1 ; i < date.length; i ++){
            date[i] = i * (i + 1);
        }
        int[] sum = new int[n + 1];
        for (int i = 1 ; i < sum.length ; i ++){
            sum[i] = date[i] + sum[i - 1];
            // 0 --- i - 1 比他大
            if (sum [i] > 2 * n) {
                System.out.println(i - 1);
                break;
            }
            // i - 1 和他相等了 
            else if (sum[i] == 2 * n){
                System.out.println(i);
                break;
            }
        }

    }
}