class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        // Iterate over each cell in the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // If the current cell is empty (i.e., it is '.')
                if (board[i][j] == '.') {
                    // Try placing digits 1 to 9
                    for (char num = '1'; num <= '9'; num++) {
                        // Check if it's valid to place the number at (i, j)
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num; // Place the number
                            
                            // Recurse to solve the next part of the board
                            if (solve(board)) {
                                return true; // If the board is solved, return true
                            }
                            
                            // If placing the number didn't lead to a solution, backtrack
                            board[i][j] = '.'; 
                        }
                    }
                    return false; // If no number can be placed, return false (backtrack)
                }
            }
        }
        return true; // If all cells are filled correctly, return true
    }
    
    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        
        // Check the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        
        // Check the 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        
        return true; // If no conflicts, the number can be placed
    }
}
