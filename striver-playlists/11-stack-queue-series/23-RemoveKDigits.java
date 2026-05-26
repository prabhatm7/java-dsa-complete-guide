/*
 * Problem: Remove K Digits to make the smallest number.
 *
 * Intuition: Monotonic increasing stack; pop while top > current and k > 0.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class RemoveKDigits {
    public String removeKdigits(String s, int k) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > c) { st.pop(); k--; }
            st.push(c);
        }
        while (k-- > 0 && !st.isEmpty()) st.pop();
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pollLast());
        while (sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
