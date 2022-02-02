/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 02/02/2022
 *   Time: 18:16
 *   File: Floor_Number.java
 */

package some_Question;

public class Floor_Number {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 9, 14, 16, 18};
        int target = 23;
        int ans = floorNumber(nums, target);
        System.out.println(ans);
    }

    private static int floorNumber(int[] nums, int target) {
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
        return end;
    }
}