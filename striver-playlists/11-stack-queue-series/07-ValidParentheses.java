/*
 * Problem: Valid Parentheses.
 *
 * Intuition: Stack of openings; pop and verify match on closers.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') st.push(c);
            else {
                if (st.isEmpty()) return false;
                char t = st.pop();
                if ((c == ')' && t != '(') || (c == ']' && t != '[') || (c == '}' && t != '{')) return false;
            }
        }
        return st.isEmpty();
    }
}
