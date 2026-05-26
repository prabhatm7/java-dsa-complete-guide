/*
 * Problem: Two Sum
 * Return indices i,j such that a[i]+a[j] = target.
 *
 * Intuition: HashMap stores value -> index; for each x check if target-x seen.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class TwoSum {
    public int[] twoSum(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int need = target - a[i];
            if (map.containsKey(need)) return new int[]{map.get(need), i};
            map.put(a[i], i);
        }
        return new int[]{-1, -1};
    }
}
