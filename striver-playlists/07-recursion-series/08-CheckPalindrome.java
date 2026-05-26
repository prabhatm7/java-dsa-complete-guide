/*
 * Problem: Check Palindrome (string) recursive.
 *
 * Intuition: Compare ends; recurse inward.
 * Time: O(n)  Space: O(n)
 */
public class CheckPalindrome {
    public boolean isPal(String s, int l, int r) {
        if (l >= r) return true;
        if (s.charAt(l) != s.charAt(r)) return false;
        return isPal(s, l + 1, r - 1);
    }
}
