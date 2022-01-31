/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 31/01/2022
 *   Time: 21:27
 *   File: BuyAndSellStockIII.java
 */

package Dynamic_Programming;

public class BuyAndSellStockIII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    public static int maxProfit(int[] prices) {

        int[][][] arr = new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++)
                    arr[i][j][k] = -1;
            }
        }
        return bestTime(prices, 0, 1, 2, arr);

    }

    public static int bestTime(int[] prices, int currentDay, int canBuy, int transCount, int[][][] memo) {
        if (currentDay >= prices.length || transCount == 0)
            return 0;


        String currentKey = Integer.toString(currentDay) + "_" + Integer.toString(canBuy) + "_" + Integer.toString(transCount);

        if (memo[currentDay][canBuy][transCount] != -1) {
            return memo[currentDay][canBuy][transCount];
        }

        int idle = bestTime(prices, currentDay + 1, canBuy, transCount, memo);


        if (canBuy == 1) {
            int buy = -prices[currentDay] + bestTime(prices, currentDay + 1, 0, transCount, memo);


            memo[currentDay][canBuy][transCount] = Math.max(idle, buy);
        } else {

            int sell = prices[currentDay] + bestTime(prices, currentDay + 1, 1, transCount - 1, memo);
            memo[currentDay][canBuy][transCount] = Math.max(idle, sell);
        }
        return memo[currentDay][canBuy][transCount];
    }
}