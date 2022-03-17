/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 17/03/2022
 *   Time: 09:46
 *   File: Flood_Fill_BFS.java
 */

package graph;

import java.util.LinkedList;
import java.util.Queue;

//Leetcode 733
class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Flood_Fill_BFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;

        }
        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));

        while (queue.size() > 0) {
            Pair currentPair = queue.remove();
            int currentRow = currentPair.x;
            int currentCol = currentPair.y;
            if (currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n || image[currentRow][currentCol] != color) {
                continue;

            }
            image[currentRow][currentCol] = newColor;
            queue.add(new Pair(currentRow - 1, currentCol));
            queue.add(new Pair(currentRow, currentCol + 1));
            queue.add(new Pair(currentRow + 1, currentCol));
            queue.add(new Pair(currentRow, currentCol - 1));

        }


        return image;

    }
}