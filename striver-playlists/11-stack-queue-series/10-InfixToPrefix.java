/*
 * Problem: Infix to Prefix.
 *
 * Intuition: Reverse infix swapping parens; infix-to-postfix with right-assoc tweak; reverse result.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class InfixToPrefix {
    public String infixToPrefix(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();
        char[] arr = sb.toString().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') arr[i] = ')';
            else if (arr[i] == ')') arr[i] = '(';
        }
        StringBuilder out = new StringBuilder();
        Deque<Character> st = new ArrayDeque<>();
        for (char c : arr) {
            if (Character.isLetterOrDigit(c)) out.append(c);
            else if (c == '(') st.push(c);
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') out.append(st.pop());
                st.pop();
            } else {
                while (!st.isEmpty() && (c == '^' ? prec(st.peek()) > prec(c) : prec(st.peek()) >= prec(c))) out.append(st.pop());
                st.push(c);
            }
        }
        while (!st.isEmpty()) out.append(st.pop());
        return out.reverse().toString();
    }
    private int prec(char c) { return c == '^' ? 3 : (c == '*' || c == '/') ? 2 : (c == '+' || c == '-') ? 1 : 0; }
}
