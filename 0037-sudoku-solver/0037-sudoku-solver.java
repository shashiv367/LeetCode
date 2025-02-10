class Solution {
    public void solveSudoku(char[][] board) {
        // Bitmask to store used digits in rows, columns, and 3x3 subgrids
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        // Pre-process the board to initialize the bitmask arrays
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1'; // Convert '1' to 0, '9' to 8
                    rows[r] |= (1 << num);
                    cols[c] |= (1 << num);
                    boxes[(r / 3) * 3 + (c / 3)] |= (1 << num);
                }
            }
        }

        // Start the backtracking process
        solve(board, rows, cols, boxes, 0, 0);
    }

    private boolean solve(char[][] board, int[] rows, int[] cols, int[] boxes, int r, int c) {
        // If we reached the end of the board
        if (r == 9) return true;
        
        // If we reached the end of the row, move to the next row
        if (c == 9) return solve(board, rows, cols, boxes, r + 1, 0);
        
        // Skip filled cells
        if (board[r][c] != '.') return solve(board, rows, cols, boxes, r, c + 1);

        // Try placing digits 1-9
        for (int num = 0; num < 9; num++) {
            // Calculate the bitmask for the current number
            int boxIdx = (r / 3) * 3 + (c / 3);
            
            // Check if placing the current number is valid
            if ((rows[r] & (1 << num)) == 0 && (cols[c] & (1 << num)) == 0 && (boxes[boxIdx] & (1 << num)) == 0) {
                // Place the number
                board[r][c] = (char) (num + '1');
                rows[r] |= (1 << num);
                cols[c] |= (1 << num);
                boxes[boxIdx] |= (1 << num);

                // Recursively attempt to solve the rest of the board
                if (solve(board, rows, cols, boxes, r, c + 1)) {
                    return true;
                }

                // Backtrack
                board[r][c] = '.';
                rows[r] &= ~(1 << num);
                cols[c] &= ~(1 << num);
                boxes[boxIdx] &= ~(1 << num);
            }
        }

        return false; // If no valid number can be placed, return false
    }
}
