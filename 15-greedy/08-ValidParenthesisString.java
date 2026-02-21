// LC 678. Valid Parenthesis String (* can be '(' or ')' or empty)
// Approach: Track range of possible open counts [lo, hi].
// '(' both increase, ')' both decrease, '*' lo decreases hi increases.
// lo = max(lo, 0). Valid if lo == 0 possible.
// Time: O(n) | Space: O(1)
class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') { lo++; hi++; }
            else if (c == ')') { lo--; hi--; }
            else { lo--; hi++; }
            if (hi < 0) return false;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}
