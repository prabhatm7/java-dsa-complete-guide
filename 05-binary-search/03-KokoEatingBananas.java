// LC 875. Koko Eating Bananas
// Approach: Binary search on eating speed k (1 to max(piles)). Check if can finish in h hours.
// Time: O(n * log(max)) | Space: O(1)
class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1;
        for (int p : piles) r = Math.max(r, p);
        while (l < r) {
            int mid = l + (r - l) / 2;
            int hours = 0;
            for (int p : piles) hours += (p + mid - 1) / mid;
            if (hours <= h) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
