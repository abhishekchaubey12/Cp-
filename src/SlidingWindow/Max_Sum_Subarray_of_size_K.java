package SlidingWindow;/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 20/03/2022
 *   Time: 17:39
 *   File:
 SlidingWindow.Max_Sum_Subarray_of_size_K.java
 */

import java.util.ArrayList;

public class Max_Sum_Subarray_of_size_K {
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        while (j < Arr.size()) {
            sum = sum + Arr.get(j);
            if (j - i + 1 < K) {
                j++;
            } else if (j - i + 1 == K) {
                max = Math.max(sum, max);
                sum = sum - Arr.get(i);
                i++;
                j++;
            }
        }
        return max;
    }


    //2nd method
    private static int solve(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0, max = Integer.MIN_VALUE, sum = 0;
        while (j < n) {
            sum += arr[j];
            if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return max;
    }

}