/*
 * Problem: Asteroid Collision.
 *
 * Intuition: Stack; positives push; negatives explode positives on top while smaller; equal annihilate.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class AsteroidCollision {
    public int[] asteroidCollision(int[] a) {
        Deque<Integer> st = new ArrayDeque<>();
        outer:
        for (int x : a) {
            while (!st.isEmpty() && x < 0 && st.peek() > 0) {
                if (st.peek() < -x) { st.pop(); continue; }
                else if (st.peek() == -x) st.pop();
                continue outer;
            }
            st.push(x);
        }
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = st.pop();
        return res;
    }
}
