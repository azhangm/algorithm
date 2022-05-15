//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package DifferenceAndPreSum;

import java.util.Scanner;

class Main {
    Main() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[m];
        int[] diff = new int[m];

        int i;
        for(i = 0; i < m; ++i) {
            nums[i] = sc.nextInt();
        }

        diff[0] = nums[0];

        for(i = 1; i < m; ++i) {
            diff[i] = nums[i] - nums[i - 1];
        }

        while(n-- > 0) {
            i = sc.nextInt();
            int r = sc.nextInt();
            int val = sc.nextInt();
            diff[i - 1] += val;
            if (r < m) {
                diff[r] -= val;
            }
        }

        nums[0] = diff[0];

        for(i = 0; i < m; ++i) {
            if (i > 0) {
                diff[i] += diff[i - 1];
                System.out.print(diff[i] + " ");
            } else {
                System.out.print(diff[0] + " ");
            }
        }

    }
}
