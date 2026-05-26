/*
 * Problem: 3Sum — all unique triplets summing to 0.
 *
 * Intuition: Sort; for each i, two-pointer l,r with skip duplicates.
 * Time: O(n^2)  Space: O(1) extra
 */
import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && a[i] == a[i-1]) continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int s = a[i] + a[l] + a[r];
                if (s == 0) {
                    res.add(Arrays.asList(a[i], a[l], a[r]));
                    l++; r--;
                    while (l < r && a[l] == a[l-1]) l++;
                    while (l < r && a[r] == a[r+1]) r--;
                } else if (s < 0) l++; else r--;
            }
        }
        return res;
    }
}
