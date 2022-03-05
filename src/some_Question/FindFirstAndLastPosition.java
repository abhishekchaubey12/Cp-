/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 02/02/2022
 *   Time: 19:48
 *   File: FindFirstAndLastPosition.java
 */

package some_Question;

public class FindFirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] res = search(nums, target);
        System.out.println(res);

    }

    public static int[] search(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = searchRange(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = searchRange(nums, target, false);
        }
        return ans;
    }

    static int searchRange(int[] nums, int target, boolean isCheck) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (target < nums[middle]) {
                end = middle - 1;
            } else if (target > nums[middle]) {
                start = middle + 1;
            } else
                ans = middle;
            if (isCheck == true) {
                end = middle - 1;
            } else {
                end = middle + 1;
            }

        }
        return ans;
    }
}