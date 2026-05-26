// LC 242. Valid Anagram
// Approach: Frequency count array of 26 chars, increment for s, decrement for t
// Time: O(n) | Space: O(1)
class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}

// Status - Accepted
// Revision Status : Not Required
