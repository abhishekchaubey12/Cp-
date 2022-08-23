/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 23/08/2022
 *   Time: 22:33
 *   File: HouseRobber2.java
 */

package Dynamic_Programming;

public class HouseRobber2 {
    public static int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(robber(nums, 0, nums.length - 1), robber(nums, 1, nums.length));
    }

    private static int robber(int[] nums, int start, int end) {
        int include = 0;
        int exclude = 0;
        int maximum = 0;
        for (int i = start; i < end; i++) {
            maximum = Math.max(include + nums[i], exclude);
            include = exclude;
            exclude = maximum;
        }
        return maximum;

    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 5, 3, 9, 5, 3}));
    }
}