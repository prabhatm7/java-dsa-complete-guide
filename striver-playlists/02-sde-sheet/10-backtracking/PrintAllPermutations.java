/*
 * Problem: Print All Permutations of a distinct array.
 *
 * Intuition: Swap-based recursion: for each index, swap with every j>=i and recurse.
 * Time: O(n! * n)  Space: O(n)
 */
import java.util.*;
public class PrintAllPermutations {
    public List<List<Integer>> permute(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        go(0, a, res);
        return res;
    }
    private void go(int i, int[] a, List<List<Integer>> res) {
        if (i == a.length) {
            List<Integer> cur = new ArrayList<>();
            for (int x : a) cur.add(x);
            res.add(cur);
            return;
        }
        for (int j = i; j < a.length; j++) {
            swap(a, i, j); go(i + 1, a, res); swap(a, i, j);
        }
    }
    private void swap(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }
}
