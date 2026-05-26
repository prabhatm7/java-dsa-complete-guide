/*
 * Problem: Majority Element (> n/2)
 *
 * Intuition: Boore-Moyer voting — maintain candidate and count; pair off opposites.
 * Time: O(n)  Space: O(1)
 */
public class MajorityElementN2 {
    public int majorityElement(int[] a) {
        int cnt = 0, cand = 0;
        for (int x : a) {
            if (cnt == 0) cand = x;
            cnt += (x == cand) ? 1 : -1;
        }
        return cand;
    }
}
