// LC 51. N-Queens
// Approach: Backtracking row by row. Track columns, diag (r-c), anti-diag (r+c) with sets.
// Time: O(n!) | Space: O(n^2)
import java.util.*;

class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(board, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), res);
        return res;
    }

    private void backtrack(char[][] board, int row, Set<Integer> cols, Set<Integer> diags, Set<Integer> antiDiags, List<List<String>> res) {
        if (row == board.length) {
            List<String> copy = new ArrayList<>();
            for (char[] r : board) copy.add(new String(r));
            res.add(copy);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (cols.contains(col) || diags.contains(row - col) || antiDiags.contains(row + col)) continue;
            board[row][col] = 'Q';
            cols.add(col); diags.add(row - col); antiDiags.add(row + col);
            backtrack(board, row + 1, cols, diags, antiDiags, res);
            board[row][col] = '.';
            cols.remove(col); diags.remove(row - col); antiDiags.remove(row + col);
        }
    }
}
