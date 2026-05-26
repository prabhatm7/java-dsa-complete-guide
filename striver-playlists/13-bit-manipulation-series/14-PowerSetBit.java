/*
 * Problem: Power Set using bitmask.
 *
 * Intuition: Iterate 0..2^n-1; bit i set => include a[i].
 * Time: O(n*2^n)  Space: O(n*2^n)
 */
import java.util.*;
public class PowerSetBit {
    public List<List<Integer>> powerSet(int[] a) {
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
