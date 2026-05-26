/*
 * Problem: Infix to Postfix conversion.
 *
 * Intuition: Shunting-yard — operands to output; operators to stack with precedence rules.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class InfixToPostfix {
    public String infixToPostfix(String s) {
        StringBuilder out = new StringBuilder();
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) out.append(c);
            else if (c == '(') st.push(c);
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') out.append(st.pop());
                st.pop();
            } else {
                while (!st.isEmpty() && prec(st.peek()) >= prec(c)) out.append(st.pop());
                st.push(c);
            }
        }
        while (!st.isEmpty()) out.append(st.pop());
        return out.toString();
    }
    private int prec(char c) { return c == '^' ? 3 : (c == '*' || c == '/') ? 2 : (c == '+' || c == '-') ? 1 : 0; }
}
