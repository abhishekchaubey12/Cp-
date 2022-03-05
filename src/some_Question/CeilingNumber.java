/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 02/02/2022
 *   Time: 18:02
 *   File: CeilingNumber.java
 */

package some_Question;

public class CeilingNumber {
    public static void main(String[] args) {
        int[] nums = {2, 4, 8, 12, 14, 18, 20};
        int target = 22;
        int ans = ceilingNumber(nums, target);
        System.out.println(ans);
    }

    // return the smallest number >= target
    private static int ceilingNumber(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (target < nums[middle]) {
                end = middle - 1;
            } else if (target > nums[middle]) {
                start = middle + 1;
            } else
                return middle;

        }
        return start;
    }

}