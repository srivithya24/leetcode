class Solution {

    public boolean validTicTacToe(String[] board) {
        int countX = 0, countO = 0;

        // Count X and O
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') countX++;
                if (c == 'O') countO++;
            }
        }

        // Rule 1: Turn validation
        if (countO > countX || countX > countO + 1) return false;

        boolean xWin = isWinner(board, 'X');
        boolean oWin = isWinner(board, 'O');

        // Rule 2: Both cannot win
        if (xWin && oWin) return false;

        // Rule 3: X wins → X must have one extra move
        if (xWin && countX != countO + 1) return false;

        // Rule 4: O wins → equal moves
        if (oWin && countX != countO) return false;

        return true;
    }

    // Check if a player wins
    private boolean isWinner(String[] board, char player) {

        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player &&
                board[i].charAt(1) == player &&
                board[i].charAt(2) == player)
                return true;

            if (board[0].charAt(i) == player &&
                board[1].charAt(i) == player &&
                board[2].charAt(i) == player)
                return true;
        }

        // Diagonals
        if (board[0].charAt(0) == player &&
            board[1].charAt(1) == player &&
            board[2].charAt(2) == player)
            return true;

        if (board[0].charAt(2) == player &&
            board[1].charAt(1) == player &&
            board[2].charAt(0) == player)
            return true;

        return false;
    }
}
