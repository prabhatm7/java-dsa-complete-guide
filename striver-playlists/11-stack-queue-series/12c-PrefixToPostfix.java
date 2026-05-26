/*
 * Problem: Prefix to Postfix conversion.
 *
 * Intuition: Walk right-to-left; stack of expressions; on operator pop two, push (a + b + op).
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class PrefixToPostfix {
    public String prefixToPostfix(String s) {
        Deque<String> st = new ArrayDeque<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) st.push(String.valueOf(c));
            else { String a = st.pop(), b = st.pop(); st.push(a + b + c); }
        }
        return st.peek();
    }
}
