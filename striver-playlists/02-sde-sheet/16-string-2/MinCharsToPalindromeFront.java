/*
 * Problem: Min Characters to add in front to make string a palindrome.
 *
 * Intuition: Build s + "#" + reverse(s); compute LPS; answer = len(s) - lps[last].
 * Time: O(n)  Space: O(n)
 */
public class MinCharsToPalindromeFront {
    public int minChars(String s) {
        String t = s + "#" + new StringBuilder(s).reverse();
        int n = t.length();
        int[] lps = new int[n];
        int len = 0, i = 1;
        while (i < n) {
            if (t.charAt(i) == t.charAt(len)) lps[i++] = ++len;
            else if (len > 0) len = lps[len - 1];
            else lps[i++] = 0;
        }
        return s.length() - lps[n - 1];
    }
}
