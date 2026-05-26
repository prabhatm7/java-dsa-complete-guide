/*
 * Problem: Postfix to Infix.
 *
 * Intuition: Stack of expressions; on operator pop two, combine with parentheses.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class PostfixToInfix {
    public String postfixToInfix(String s) {
        Deque<String> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) st.push(String.valueOf(c));
            else { String b = st.pop(), a = st.pop(); st.push("(" + a + c + b + ")"); }
        }
        return st.peek();
    }
}
