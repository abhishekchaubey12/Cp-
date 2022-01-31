/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 31/01/2022
 *   Time: 21:41
 *   File: BuyAndSellStockIV.java
 */

package Dynamic_Programming;

import java.util.HashMap;

public class BuyAndSellStockIV {
    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{2, 4, 1}));
    }

    public static int maxProfit(int k, int[] prices) {
        return bestTime(prices, 0, true, k, new HashMap<>());

    }

    public static int bestTime(int[] prices, int currentDay, boolean canBuy, int k, HashMap<String, Integer> memo) {
        if (currentDay >= prices.length || k == 0)
            return 0;


        String currentKey = Integer.toString(currentDay) + "_" + Boolean.toString(canBuy) + "_" + Integer.toString(k);

        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }

        int idle = bestTime(prices, currentDay + 1, canBuy, k, memo);


        if (canBuy == true) {
            int buy = -prices[currentDay] + bestTime(prices, currentDay + 1, false, k, memo);


            memo.put(currentKey, Math.max(idle, buy));
        }
        if (canBuy == false) {

            int sell = prices[currentDay] + bestTime(prices, currentDay + 1, true, k - 1, memo);
            memo.put(currentKey, Math.max(idle, sell));
        }
        return memo.get(currentKey);
    }
}