/*
 * Problem: Combination Sum II — each number used at most once; unique combos.
 *
 * Intuition: Sort; iterate from i to n, skip duplicates at same depth; move forward (j+1).
 * Time: O(2^n * k)  Space: O(k)
 */
import java.util.*;
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] a, int t) {
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        go(0, a, t, new ArrayList<>(), res);
        return res;
    }
    private void go(int i, int[] a, int t, List<Integer> cur, List<List<Integer>> res) {
        if (t == 0) { res.add(new ArrayList<>(cur)); return; }
        for (int j = i; j < a.length; j++) {
            if (j > i && a[j] == a[j-1]) continue;
            if (a[j] > t) break;
            cur.add(a[j]);
            go(j + 1, a, t - a[j], cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
