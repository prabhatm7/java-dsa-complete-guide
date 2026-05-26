/*
 * Problem: Print all subsequences of an array.
 *
 * Intuition: At each index, take or not take.
 * Time: O(2^n)  Space: O(n)
 */
import java.util.*;
public class AllSubsequences {
    public List<List<Integer>> all(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        go(0, a, new ArrayList<>(), res);
        return res;
    }
    private void go(int i, int[] a, List<Integer> cur, List<List<Integer>> res) {
        if (i == a.length) { res.add(new ArrayList<>(cur)); return; }
        cur.add(a[i]); go(i + 1, a, cur, res); cur.remove(cur.size() - 1);
        go(i + 1, a, cur, res);
    }
}
