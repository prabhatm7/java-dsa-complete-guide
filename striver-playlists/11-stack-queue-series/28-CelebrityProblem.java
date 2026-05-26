/*
 * Problem: Celebrity Problem — find one who knows nobody but is known by all.
 *
 * Intuition: Two pointers approach; if knows(l,r) l++ else r--; verify candidate.
 * Time: O(n)  Space: O(1)
 */
public class CelebrityProblem {
    public int celebrity(int[][] m) {
        int n = m.length, l = 0, r = n - 1;
        while (l < r) {
            if (m[l][r] == 1) l++; else r--;
        }
        for (int i = 0; i < n; i++) {
            if (i != l && (m[l][i] == 1 || m[i][l] == 0)) return -1;
        }
        return l;
    }
}
