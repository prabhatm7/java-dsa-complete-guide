/*
 * Problem: Valid Anagram.
 *
 * Intuition: Counting array of 26; +1 for s, -1 for t; final all zeros.
 * Time: O(n)  Space: O(1)
 */
public class CheckAnagrams {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) { cnt[s.charAt(i) - 'a']++; cnt[t.charAt(i) - 'a']--; }
        for (int c : cnt) if (c != 0) return false;
        return true;
    }
}
