/*
 * Problem: Subsequences with sum K.
 *
 * Intuition: Take/not-take; collect when remaining sum == 0.
 * Time: O(2^n)  Space: O(n)
 */
import java.util.*;
public class SubsequencesSumK {
    public List<List<Integer>> find(int[] a, int k) {
        List<List<Integer>> res = new ArrayList<>();
        go(0, a, k, new ArrayList<>(), res);
        return res;
    }
    private void go(int i, int[] a, int k, List<Integer> cur, List<List<Integer>> res) {
        if (i == a.length) { if (k == 0) res.add(new ArrayList<>(cur)); return; }
        cur.add(a[i]); go(i + 1, a, k - a[i], cur, res); cur.remove(cur.size() - 1);
        go(i + 1, a, k, cur, res);
    }
}
