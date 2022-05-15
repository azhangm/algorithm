//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package DifferenceAndPreSum;

import java.util.Arrays;

class lk1109 {
    lk1109() {
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        int[][] var3 = bookings;
        int var4 = bookings.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            int[] book = var3[var5];
            int l = book[0];
            int r = book[1];
            int val = book[2];
            diff[l - 1] += val;
            if (r + 1 < n) {
                diff[r] -= val;
            }
        }

        for(int i = 1; i < n; ++i) {
            diff[i] += diff[i - 1];
        }

        return diff;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{{3, 3, 5}, {1, 3, 20}, {1, 2, 15}}, 3)));
    }
}
