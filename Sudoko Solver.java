class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {

                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(board, i, j, num)) {

                            board[i][j] = num;

                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack
                            board[i][j] = '.';
                        }
                    }

                    return false; // no valid number found
                }
            }
        }

        return true; // solved
    }

    private boolean isValid(char[][] board, int row, int col, char num) {

        for (int i = 0; i < 9; i++) {

            // Check row
            if (board[row][i] == num) return false;

            // Check column
            if (board[i][col] == num) return false;

            // Check 3x3 box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;

            if (board[boxRow][boxCol] == num) return false;
        }

        return true;
    }
}
