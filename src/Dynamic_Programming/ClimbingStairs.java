/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 23/08/2022
 *   Time: 22:06
 *   File: ClimbingStairs.java
 */

package Dynamic_Programming;

import java.util.HashMap;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        return totalWays(0, n, new HashMap<Integer, Integer>());
    }

    public static int totalWays(int currentStair, int targetStair, HashMap<Integer, Integer> memo) {
        if (currentStair == targetStair) {
            return 1;
        }
        if (currentStair > targetStair) {
            return 0;
        }
        int currentKey = currentStair;
        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }

        int oneStep = totalWays(currentStair + 1, targetStair, memo);
        int twoStep = totalWays(currentStair + 2, targetStair, memo);

        memo.put(currentStair, oneStep + twoStep);
        return oneStep + twoStep;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}