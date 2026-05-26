/*
 * Problem: Subarrays with exactly K Distinct integers.
 *
 * Intuition: atMost(K) - atMost(K-1).
 * Time: O(n)  Space: O(k)
 */
import java.util.*;
public class SubarraysWithKDistinct {
    public int subarraysWithKDistinct(int[] a, int k) {
        return atMost(a, k) - atMost(a, k - 1);
    }
    private int atMost(int[] a, int k) {
        if (k < 0) return 0;
        Map<Integer, Integer> m = new HashMap<>();
        int l = 0, ans = 0;
        for (int r = 0; r < a.length; r++) {
            m.merge(a[r], 1, Integer::sum);
            while (m.size() > k) if (m.merge(a[l++], -1, Integer::sum) == 0) m.remove(a[l-1]);
            ans += r - l + 1;
        }
        return ans;
    }
}
