/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 20/03/2022
 *   Time: 09:08
 *   File: ZeroSum_SubArray.java
 */

package HashMap;

import java.util.HashMap;

public class ZeroSum_SubArray {
    public static long findSubarray(long[] arr, int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();

        int prefixSum = 0;
        int ans = 0;
        memo.put(prefixSum, 1);
        for (int i = 0; i < n; i++) {
            long currentValue = arr[i];

            prefixSum += currentValue;
            if (memo.containsKey(prefixSum)) {
                int value = memo.get(prefixSum);
                ans += value;
                memo.put(prefixSum, value + 1);
            } else {
                memo.put(prefixSum, 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        long[] arr = {0, 0, 5, 5, 0, 0};
        System.out.println(findSubarray(arr, arr.length)); // 4
    }
}