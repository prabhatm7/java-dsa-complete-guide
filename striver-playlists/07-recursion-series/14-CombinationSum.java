/*
 * Problem: Combination Sum — unique combos summing to target (unlimited reuse).
 *
 * Intuition: At index i: take (stay at i) or move to i+1.
 * Time: O(2^t)  Space: O(t)
 */
import java.util.*;
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] a, int t) {
        List<List<Integer>> res = new ArrayList<>();
        go(0, a, t, new ArrayList<>(), res);
        return res;
    }
    private void go(int i, int[] a, int t, List<Integer> cur, List<List<Integer>> res) {
        if (i == a.length) { if (t == 0) res.add(new ArrayList<>(cur)); return; }
        if (a[i] <= t) { cur.add(a[i]); go(i, a, t - a[i], cur, res); cur.remove(cur.size() - 1); }
        go(i + 1, a, t, cur, res);
    }
}
