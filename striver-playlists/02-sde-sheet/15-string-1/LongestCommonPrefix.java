/*
 * Problem: Longest Common Prefix among strings.
 *
 * Intuition: Sort lexicographically; compare first and last only.
 * Time: O(n log n + m)  Space: O(1)
 */
import java.util.*;
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        Arrays.sort(strs);
        String a = strs[0], b = strs[strs.length - 1];
        int i = 0;
        while (i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i)) i++;
        return a.substring(0, i);
    }
}
