/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 27/03/2022
 *   Time: 11:01
 *   File: Word_Search.java
 */

package graph;

public class Word_Search {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        if (word.length() == 0) {
            return true;
        }
        // if board size (rows*cols) < word length, => word has some character(s) not present in board. So, just return False. This is
        // optimized way as we are avoiding doing DFS search in such test cases.
        if (rows * cols < word.length()) {
            return false;
        }
        //traverse all the char boards.
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) {
                    boolean isFound = dfs(board, new boolean[rows][cols], r, c, word, 0);
                    if (isFound) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int r, int c, String word, int wordIndex) {
        if ((r < 0 || r >= board.length) || (c < 0 || c >= board[0].length) || board[r][c] != word.charAt(wordIndex)) {
            return false;
        }
        if (visited[r][c]) {
            return false;
        }
        if (wordIndex == word.length() - 1) {
            return true;
        }
        visited[r][c] = true;

        if (dfs(board, visited, r, c - 1, word, wordIndex + 1)) {
            return true;
        }

        if (dfs(board, visited, r + 1, c, word, wordIndex + 1))
            return true;
        if (dfs(board, visited, r - 1, c, word, wordIndex + 1))
            return true;
        if (dfs(board, visited, r, c + 1, word, wordIndex + 1))
            return true;

        visited[r][c] = false;
        return false;
    }
}