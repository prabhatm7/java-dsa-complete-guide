/*
 * Problem: Postfix to Prefix conversion.
 *
 * Intuition: Stack of expressions; on operator pop two, push (op + a + b).
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class PostfixToPrefix {
    public String postfixToPrefix(String s) {
        Deque<String> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) st.push(String.valueOf(c));
            else { String b = st.pop(), a = st.pop(); st.push(c + a + b); }
        }
        return st.peek();
    }
}
