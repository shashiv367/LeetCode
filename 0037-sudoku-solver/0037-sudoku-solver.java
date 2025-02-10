class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {  // Find an empty cell
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {  // Check if placing the number is valid
                            board[i][j] = c;  // Place the number
                            if (solve(board)) {  // Recursively try to solve the rest of the board
                                return true;
                            }
                            board[i][j] = '.';  // Backtrack if it doesn't work
                        }
                    }
                    return false;  // If no number is valid, return false to backtrack
                }
            }
        }
        return true;  // If the whole board is filled correctly
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) {
                return false;
            }
        }
        
        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }

        // Check 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        
        return true;  // Valid placement
    }
}
