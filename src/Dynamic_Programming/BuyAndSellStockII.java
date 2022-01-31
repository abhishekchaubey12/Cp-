/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 31/01/2022
 *   Time: 21:22
 *   File: BuyAndSellStockII.java
 */

package Dynamic_Programming;

import java.util.HashMap;

public class BuyAndSellStockII {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        return bestTime(prices, 0, true, new HashMap<>());

    }

    public static int bestTime(int[] prices, int currentDay, boolean canBuy, HashMap<String, Integer> memo) {
        if (currentDay >= prices.length)
            return 0;


        String currentKey = Integer.toString(currentDay) + "_" + Boolean.toString(canBuy);

        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }

        int idle = bestTime(prices, currentDay + 1, canBuy, memo);


        if (canBuy == true) {
            int buy = -prices[currentDay] + bestTime(prices, currentDay + 1, false, memo);


            memo.put(currentKey, Math.max(idle, buy));
        }
        if (canBuy == false) {

            int sell = prices[currentDay] + bestTime(prices, currentDay + 1, true, memo);
            memo.put(currentKey, Math.max(idle, sell));
        }
        return memo.get(currentKey);
    }
}