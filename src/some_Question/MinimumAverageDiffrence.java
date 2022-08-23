/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 23/08/2022
 *   Time: 22:03
 *   File: MinimumAverageDiffrence.java
 */

package some_Question;

public class MinimumAverageDiffrence {
    public static void main(String[] args) {
        System.out.println(minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3}));
    }

    public static int minimumAverageDifference(int[] nums) {
        int len = nums.length, res = 0;
        long min = Integer.MAX_VALUE, sum = 0, leftSum = 0, rightSum = 0;
        for (int num : nums)
            sum += num;
        for (int i = 0; i < len; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;
            long diff = Math.abs(leftSum / (i + 1) - (len - i == 1 ? 0 : rightSum / (len - i - 1)));
            if (diff < min) {
                min = diff;
                res = i;
            }
        }
        return res;
    }
}