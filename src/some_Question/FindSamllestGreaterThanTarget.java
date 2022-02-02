/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 02/02/2022
 *   Time: 18:23
 *   File: FindSamllestGreaterThanTarget.java
 */

package some_Question;

public class FindSamllestGreaterThanTarget {
    public static void main(String[] args) {
        char[] nums = {'c', 'f', 'j'};
        char target = 'a';
        char ans = smallestNumber(nums, target);
        System.out.println(ans);
    }

    private static char smallestNumber(char[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (target < nums[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return nums[start % nums.length];
    }
}