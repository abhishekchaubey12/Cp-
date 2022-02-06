/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 06/02/2022
 *   Time: 13:11
 *   File: Subsets.java
 */
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();

        generateSubset(nums, 0, new ArrayList<>(), powerSet);
        return powerSet;

    }

    private static void generateSubset(int[] nums, int currentIndex, List<Integer> currentSubset, List<List<Integer>> powerSet) {
        if (currentIndex == nums.length) {
            powerSet.add(new ArrayList<>(currentSubset));
            return;
        }
        int currentVal = nums[currentIndex];
        currentSubset.add(currentVal);
        generateSubset(nums, currentIndex + 1, currentSubset, powerSet);

        currentSubset.remove(currentSubset.size() - 1);
        generateSubset(nums, currentIndex + 1, currentSubset, powerSet);
        return;
    }
}