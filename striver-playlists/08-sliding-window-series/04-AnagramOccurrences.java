/*
 * Problem: Count occurrences of anagrams of p in s.
 *
 * Intuition: Char-frequency window of size |p|; compare arrays.
 * Time: O(n)  Space: O(26)
 */
public class AnagramOccurrences {
    public int count(String s, String p) {
        int n = s.length(), m = p.length(), cnt = 0;
        if (n < m) return 0;
        int[] need = new int[26], have = new int[26];
        for (int i = 0; i < m; i++) { need[p.charAt(i)-'a']++; have[s.charAt(i)-'a']++; }
        if (java.util.Arrays.equals(need, have)) cnt++;
        for (int i = m; i < n; i++) {
            have[s.charAt(i)-'a']++;
            have[s.charAt(i-m)-'a']--;
            if (java.util.Arrays.equals(need, have)) cnt++;
        }
        return cnt;
    }
}
