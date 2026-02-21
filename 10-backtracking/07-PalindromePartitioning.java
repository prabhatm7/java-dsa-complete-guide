// LC 131. Palindrome Partitioning
// Approach: Backtracking. At each position, try all palindrome substrings starting there.
// Time: O(n * 2^n) | Space: O(n)
import java.util.*;

class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, int start, List<String> curr, List<List<String>> res) {
        if (start == s.length()) { res.add(new ArrayList<>(curr)); return; }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                backtrack(s, end + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) { if (s.charAt(l++) != s.charAt(r--)) return false; }
        return true;
    }
}
