/*
 * Problem: Trapping Rain Water
 *
 * Intuition: Two pointers; water at i bounded by min(maxLeft, maxRight); advance the smaller side.
 * Time: O(n)  Space: O(1)
 */
public class TrappingRainWater {
    public int trap(int[] h) {
        int l = 0, r = h.length - 1, lm = 0, rm = 0, ans = 0;
        while (l < r) {
            if (h[l] <= h[r]) {
                if (h[l] >= lm) lm = h[l]; else ans += lm - h[l];
                l++;
            } else {
                if (h[r] >= rm) rm = h[r]; else ans += rm - h[r];
                r--;
            }
        }
        return ans;
    }
}
