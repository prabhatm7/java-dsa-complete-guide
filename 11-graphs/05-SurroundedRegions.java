// LC 130. Surrounded Regions
// Approach: DFS from border 'O's, mark as safe 'S'. Flip remaining 'O' to 'X', restore 'S' to 'O'.
// Time: O(m*n) | Space: O(m*n)
class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) { dfs(board, i, 0); dfs(board, i, n - 1); }
        for (int j = 0; j < n; j++) { dfs(board, 0, j); dfs(board, m - 1, j); }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'S') board[i][j] = 'O';
            }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = 'S';
        dfs(board, i+1, j); dfs(board, i-1, j); dfs(board, i, j+1); dfs(board, i, j-1);
    }
}
