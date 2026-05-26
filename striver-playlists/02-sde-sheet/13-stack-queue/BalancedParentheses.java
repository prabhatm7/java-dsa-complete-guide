/*
 * Problem: Valid Parentheses for "()[]{}"
 *
 * Intuition: Stack of opens; on closing, pop and check match.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class BalancedParentheses {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') st.push(c);
            else {
                if (st.isEmpty()) return false;
                char t = st.pop();
                if (c == ')' && t != '(') return false;
                if (c == ']' && t != '[') return false;
                if (c == '}' && t != '{') return false;
            }
        }
        return st.isEmpty();
    }
}
