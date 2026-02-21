// LC 647. Palindromic Substrings
// Approach: Top-down memoization. isPalin(l, r) with memo.
// Count all (l, r) pairs where isPalin returns true.
// Time: O(n^2) | Space: O(n^2)
class PalindromicSubstrings {
    private Boolean[][] memo;

    public int countSubstrings(String s) {
        int n = s.length();
        memo = new Boolean[n][n];
        int count = 0;
        for (int l = 0; l < n; l++)
            for (int r = l; r < n; r++)
                if (isPalin(s, l, r)) count++;
        return count;
    }

    private boolean isPalin(String s, int l, int r) {
        if (l >= r) return true;
        if (memo[l][r] != null) return memo[l][r];
        memo[l][r] = (s.charAt(l) == s.charAt(r)) && isPalin(s, l + 1, r - 1);
        return memo[l][r];
    }
}
