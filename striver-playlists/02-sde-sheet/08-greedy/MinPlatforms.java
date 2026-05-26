/*
 * Problem: Minimum Platforms required at a railway station.
 *
 * Intuition: Sort arrivals and departures; sweep — increment on arrival, decrement on departure; track max.
 * Time: O(n log n)  Space: O(1)
 */
import java.util.*;
public class MinPlatforms {
    public int findPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr); Arrays.sort(dep);
        int n = arr.length, i = 0, j = 0, cur = 0, best = 0;
        while (i < n) {
            if (arr[i] <= dep[j]) { cur++; i++; if (cur > best) best = cur; }
            else { cur--; j++; }
        }
        return best;
    }
}
