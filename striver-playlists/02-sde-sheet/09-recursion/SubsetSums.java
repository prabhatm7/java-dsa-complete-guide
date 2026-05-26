/*
 * Problem: Subset Sums — return sums of all subsets.
 *
 * Intuition: Recurse with pick/not-pick; size 2^n result.
 * Time: O(2^n)  Space: O(2^n)
 */
import java.util.*;
public class SubsetSums {
    public List<Integer> subsetSums(int[] a) {
        List<Integer> res = new ArrayList<>();
        go(a, 0, 0, res);
        return res;
    }
    private void go(int[] a, int i, int s, List<Integer> r) {
        if (i == a.length) { r.add(s); return; }
        go(a, i + 1, s + a[i], r);
        go(a, i + 1, s, r);
    }
}
