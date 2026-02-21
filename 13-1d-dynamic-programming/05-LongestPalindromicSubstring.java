// LC 5. Longest Palindromic Substring
// Approach: Top-down memoization. isPalindrome(l, r) checks if s[l..r] is a palindrome.
// memo[l][r] caches result. Check all substrings, track longest palindrome.
// Time: O(n^2) | Space: O(n^2)
class LongestPalindromicSubstring {
    private Boolean[][] memo;

    public String longestPalindrome(String s) {
        int n = s.length();
        memo = new Boolean[n][n];
        int start = 0, maxLen = 1;
        for (int len = 2; len <= n; len++)
            for (int l = 0; l <= n - len; l++) {
                int r = l + len - 1;
                if (isPalin(s, l, r) && len > maxLen) {
                    start = l;
                    maxLen = len;
                }
            }
        return s.substring(start, start + maxLen);
    }

    private boolean isPalin(String s, int l, int r) {
        if (l >= r) return true;
        if (memo[l][r] != null) return memo[l][r];
        memo[l][r] = (s.charAt(l) == s.charAt(r)) && isPalin(s, l + 1, r - 1);
        return memo[l][r];
    }
}
