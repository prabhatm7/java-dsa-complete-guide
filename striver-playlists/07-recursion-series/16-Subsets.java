/*
 * Problem: Subsets (distinct array).
 *
 * Intuition: Bitmask iteration over 2^n masks.
 * Time: O(n*2^n)  Space: O(n*2^n)
 */
import java.util.*;
public class Subsets {
    public List<List<Integer>> subsets(int[] a) {
        int n = a.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int m = 0; m < (1 << n); m++) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < n; i++) if ((m & (1 << i)) != 0) cur.add(a[i]);
            res.add(cur);
        }
        return res;
    }
}
