/*
 * Problem: Palindrome Partitioning — partition s into palindromic substrings.
 *
 * Intuition: Try every cut; if prefix is palindrome, recurse on suffix.
 * Time: O(2^n * n)  Space: O(n)
 */
import java.util.*;
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        go(0, s, new ArrayList<>(), res);
        return res;
    }
    private void go(int i, String s, List<String> cur, List<List<String>> res) {
        if (i == s.length()) { res.add(new ArrayList<>(cur)); return; }
        for (int j = i; j < s.length(); j++) {
            if (isPal(s, i, j)) {
                cur.add(s.substring(i, j + 1));
                go(j + 1, s, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    private boolean isPal(String s, int l, int r) {
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }
}
