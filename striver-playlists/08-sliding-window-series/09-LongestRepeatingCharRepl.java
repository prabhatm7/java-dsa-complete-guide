/*
 * Problem: Longest Repeating Character Replacement (at most k replacements).
 *
 * Intuition: Window valid if (windowLen - maxFreq) <= k; expand or shrink.
 * Time: O(n)  Space: O(26)
 */
public class LongestRepeatingCharRepl {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int l = 0, maxF = 0, best = 0;
        for (int r = 0; r < s.length(); r++) {
            cnt[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, cnt[s.charAt(r) - 'A']);
            while ((r - l + 1) - maxF > k) cnt[s.charAt(l++) - 'A']--;
            best = Math.max(best, r - l + 1);
        }
        return best;
    }
}
