/*
 * Problem: Number of substrings containing all three chars (a,b,c).
 *
 * Intuition: Track last index of each; ans += min(last)+1 per r.
 * Time: O(n)  Space: O(1)
 */
public class SubstringsWithAllThree {
    public int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
            ans += 1 + Math.min(last[0], Math.min(last[1], last[2]));
        }
        return ans;
    }
}
