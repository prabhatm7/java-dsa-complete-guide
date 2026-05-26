/*
 * Problem: Sudoku Solver.
 *
 * Intuition: Backtracking on empty cells; trial 1-9; validate row/col/box.
 * Time: O(9^k)  Space: O(1)
 */
public class Sudoku {
    public void solveSudoku(char[][] b) { solve(b); }
    private boolean solve(char[][] b) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (b[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++)
                        if (valid(b, i, j, c)) {
                            b[i][j] = c;
                            if (solve(b)) return true;
                            b[i][j] = '.';
                        }
                    return false;
                }
        return true;
    }
    private boolean valid(char[][] b, int r, int c, char ch) {
        for (int k = 0; k < 9; k++) {
            if (b[r][k] == ch || b[k][c] == ch) return false;
            if (b[3*(r/3) + k/3][3*(c/3) + k%3] == ch) return false;
        }
        return true;
    }
}
