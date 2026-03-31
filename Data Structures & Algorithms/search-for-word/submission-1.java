class Solution {

    int rows, cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(board, word, r, c, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {

        // Found entire word
        if (index == word.length()) {
            return true;
        }

        // Boundary + mismatch check
        if (r < 0 || c < 0 || r >= rows || c >= cols
                || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark visited
        char temp = board[r][c];
        board[r][c] = '#';

        boolean found =
                dfs(board, word, r + 1, c, index + 1) ||
                dfs(board, word, r - 1, c, index + 1) ||
                dfs(board, word, r, c + 1, index + 1) ||
                dfs(board, word, r, c - 1, index + 1);

        // UNDO (backtracking)
        board[r][c] = temp;

        return found;
    }
}
