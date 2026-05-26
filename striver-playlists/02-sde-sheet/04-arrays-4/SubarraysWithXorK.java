/*
 * Problem: Count Subarrays with XOR = K
 *
 * Intuition: For prefix xor px, need previous prefix py such that py ^ K = px; count occurrences in map.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class SubarraysWithXorK {
    public int subarraysWithXor(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int xr = 0, cnt = 0;
        map.put(0, 1);
        for (int x : a) {
            xr ^= x;
            cnt += map.getOrDefault(xr ^ k, 0);
            map.merge(xr, 1, Integer::sum);
        }
        return cnt;
    }
}
