class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Start DFS if the first character matches
                if (board[r][c] == word.charAt(0)) {
                    if (backtrack(board, word, r, c, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int r, int c, int index) {
        // Base Case: All characters found
        if (index == word.length()) {
            return true;
        }

        // Boundary and character check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || 
            board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited
        char temp = board[r][c];
        board[r][c] = '#';

        // Explore 4 directions: Down, Up, Right, Left
        boolean found = backtrack(board, word, r + 1, c, index + 1) ||
                        backtrack(board, word, r - 1, c, index + 1) ||
                        backtrack(board, word, r, c + 1, index + 1) ||
                        backtrack(board, word, r, c - 1, index + 1);

        // Backtrack: Restore the cell's original value
        board[r][c] = temp;

        return found;
    }
}
