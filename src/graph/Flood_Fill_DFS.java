/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 17/03/2022
 *   Time: 09:42
 *   File: Flood_Fill_DFS.java
 */

package graph;

// Leetcode: 733
public class Flood_Fill_DFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;

        }
        sinkGraph(image, sr, sc, image[sr][sc], image.length, image[0].length, newColor);
        return image;

    }

    private void sinkGraph(int[][] image, int currentRow, int currentCol, int color, int m, int n, int newColor) {
        if (currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n || image[currentRow][currentCol] != color) {
            return;

        }
        image[currentRow][currentCol] = newColor;

        sinkGraph(image, currentRow - 1, currentCol, color, m, n, newColor);
        sinkGraph(image, currentRow + 1, currentCol, color, m, n, newColor);
        sinkGraph(image, currentRow, currentCol - 1, color, m, n, newColor);
        sinkGraph(image, currentRow, currentCol + 1, color, m, n, newColor);
        return;

    }
}