/*
 * Problem: KMP — find pattern in text using LPS (longest proper prefix that is also suffix).
 *
 * Intuition: Precompute LPS to skip matched prefix on mismatch.
 * Time: O(n + m)  Space: O(m)
 */
import java.util.*;
public class KMP {
    public List<Integer> search(String t, String p) {
        int[] lps = buildLPS(p);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0, n = t.length(), m = p.length();
        while (i < n) {
            if (t.charAt(i) == p.charAt(j)) { i++; j++; if (j == m) { res.add(i - m); j = lps[j - 1]; } }
            else if (j > 0) j = lps[j - 1]; else i++;
        }
        return res;
    }
    private int[] buildLPS(String p) {
        int m = p.length(); int[] lps = new int[m]; int len = 0, i = 1;
        while (i < m) {
            if (p.charAt(i) == p.charAt(len)) { lps[i++] = ++len; }
            else if (len > 0) len = lps[len - 1]; else lps[i++] = 0;
        }
        return lps;
    }
}
