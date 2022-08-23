/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 23/08/2022
 *   Time: 22:06
 *   File: HouseRobber.java
 */

package Dynamic_Programming;

import java.util.HashMap;

public class HouseRobber {
    public static int rob(int[] nums) {

        return maxMoney(nums, 0, new HashMap<Integer, Integer>());
    }

    public static int maxMoney(int[] nums, int currentIndex, HashMap<Integer, Integer> memo) {
        if (currentIndex >= nums.length) {
            return 0;
        }
        int currentKey = currentIndex;=
        if (memo.containsKey(currentIndex)) {
            return memo.get(currentKey);
        }
        int rob = nums[currentIndex] + maxMoney(nums, currentIndex + 2, memo);
        int noRob = maxMoney(nums, currentIndex + 1, memo);

        memo.put(currentKey, Math.max(rob, noRob));

        return Math.max(rob, noRob);

    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 5, 3, 9, 5, 3}));
    }
}