/*
 * Problem: All permutations.
 *
 * Intuition: Swap-based recursion.
 * Time: O(n!)  Space: O(n)
 */
import java.util.*;
public class Permutations {
    public List<List<Integer>> permute(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        go(0, a, res);
        return res;
    }
    private void go(int i, int[] a, List<List<Integer>> res) {
        if (i == a.length) {
            List<Integer> c = new ArrayList<>();
            for (int x : a) c.add(x);
            res.add(c);
            return;
        }
        for (int j = i; j < a.length; j++) {
            swap(a, i, j); go(i + 1, a, res); swap(a, i, j);
        }
    }
    private void swap(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }
}
