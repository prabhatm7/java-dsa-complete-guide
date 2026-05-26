/*
 * Problem: Prefix to Infix.
 *
 * Intuition: Walk right-to-left; same stack approach; combine on operator.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class PrefixToInfix {
    public String prefixToInfix(String s) {
        Deque<String> st = new ArrayDeque<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) st.push(String.valueOf(c));
            else { String a = st.pop(), b = st.pop(); st.push("(" + a + c + b + ")"); }
        }
        return st.peek();
    }
}
