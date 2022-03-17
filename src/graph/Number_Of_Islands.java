/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 17/03/2022
 *   Time: 11:14
 *   File: Number_Of_Islands.java
 */

package graph;

public class Number_Of_Islands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = 0;
        for (int currentRow = 0; currentRow < m; currentRow++) {
            for (int currentCol = 0; currentCol < n; currentCol++) {
                if (grid[currentRow][currentCol] == '1') {
                    answer += 1;
                    sinkIsland(grid, currentRow, currentCol, m, n);
                }
            }


        }
        return answer;
    }

    private void sinkIsland(char[][] grid, int currentRow, int currentCol, int m, int n) {
        if (currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n || grid[currentRow][currentCol] == '0') {
            return;
        }
        grid[currentRow][currentCol] = '0';
        sinkIsland(grid, currentRow - 1, currentCol, m, n);
        sinkIsland(grid, currentRow + 1, currentCol, m, n);
        sinkIsland(grid, currentRow, currentCol + 1, m, n);
        sinkIsland(grid, currentRow, currentCol - 1, m, n);
    }
}