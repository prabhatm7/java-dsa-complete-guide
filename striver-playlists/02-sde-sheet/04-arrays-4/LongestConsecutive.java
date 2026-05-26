/*
 * Problem: Longest Consecutive Sequence
 *
 * Intuition: Put all in HashSet; only start counting from x if x-1 not in set (sequence start).
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class LongestConsecutive {
    public int longestConsecutive(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int x : a) set.add(x);
        int best = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int y = x, len = 1;
                while (set.contains(y + 1)) { y++; len++; }
                if (len > best) best = len;
            }
        }
        return best;
    }
}
