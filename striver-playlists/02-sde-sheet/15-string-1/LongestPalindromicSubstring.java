/*
 * Problem: Longest Palindromic Substring.
 *
 * Intuition: Expand around each center (odd and even); track best span.
 * Time: O(n^2)  Space: O(1)
 */
public class LongestPalindromicSubstring {
    int start = 0, len = 0;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) { expand(s, i, i); expand(s, i, i + 1); }
        return s.substring(start, start + len);
    }
    private void expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
        if (r - l - 1 > len) { len = r - l - 1; start = l + 1; }
    }
}
