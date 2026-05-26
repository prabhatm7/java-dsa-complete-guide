/*
 * Problem: Subsets II — all unique subsets when array has duplicates.
 *
 * Intuition: Sort; at each index, take, recurse; then skip all duplicates before next iteration.
 * Time: O(2^n)  Space: O(n)
 */
import java.util.*;
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        go(0, a, new ArrayList<>(), res);
        return res;
    }
    private void go(int i, int[] a, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
        for (int j = i; j < a.length; j++) {
            if (j > i && a[j] == a[j-1]) continue;
            cur.add(a[j]);
            go(j + 1, a, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
