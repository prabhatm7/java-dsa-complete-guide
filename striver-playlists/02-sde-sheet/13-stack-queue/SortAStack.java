/*
 * Problem: Sort a Stack using recursion only.
 *
 * Intuition: Pop top, sort rest, insert top in correct place via recursion.
 * Time: O(n^2)  Space: O(n)
 */
import java.util.*;
public class SortAStack {
    public void sort(Stack<Integer> s) {
        if (s.isEmpty()) return;
        int t = s.pop();
        sort(s);
        insert(s, t);
    }
    private void insert(Stack<Integer> s, int x) {
        if (s.isEmpty() || s.peek() <= x) { s.push(x); return; }
        int t = s.pop();
        insert(s, x);
        s.push(t);
    }
}
