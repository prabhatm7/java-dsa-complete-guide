/*
 * Problem: 4Sum
 * Find all unique quadruplets summing to target.
 *
 * Intuition: Sort, fix two outer pointers, use two-pointer for inner pair; skip duplicates carefully.
 * Time: O(n^3)  Space: O(1) extra
 */
import java.util.*;
public class FourSum {
    public List<List<Integer>> fourSum(int[] a, int target) {
        Arrays.sort(a);
        int n = a.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && a[i] == a[i-1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && a[j] == a[j-1]) continue;
                int l = j + 1, r = n - 1;
                while (l < r) {
                    long s = (long) a[i] + a[j] + a[l] + a[r];
                    if (s == target) {
                        res.add(Arrays.asList(a[i], a[j], a[l], a[r]));
                        l++; r--;
                        while (l < r && a[l] == a[l-1]) l++;
                        while (l < r && a[r] == a[r+1]) r--;
                    } else if (s < target) l++; else r--;
                }
            }
        }
        return res;
    }
}
