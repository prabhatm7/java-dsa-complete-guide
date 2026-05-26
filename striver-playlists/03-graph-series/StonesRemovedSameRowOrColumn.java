/*
 * Problem: Most Stones Removed with Same Row or Column.
 *
 * Intuition: Union stones sharing row or column; answer = n - number of components.
 * Time: O(n*alpha)  Space: O(n)
 */
import java.util.*;
public class StonesRemovedSameRowOrColumn {
    int[] par;
    public int removeStones(int[][] stones) {
        Map<Integer, Integer> row = new HashMap<>(), col = new HashMap<>();
        int n = stones.length;
        par = new int[n];
        for (int i = 0; i < n; i++) par[i] = i;
        for (int i = 0; i < n; i++) {
            int r = stones[i][0], c = stones[i][1];
            if (row.containsKey(r)) union(i, row.get(r)); else row.put(r, i);
            if (col.containsKey(c)) union(i, col.get(c)); else col.put(c, i);
        }
        int comp = 0;
        for (int i = 0; i < n; i++) if (find(i) == i) comp++;
        return n - comp;
    }
    private int find(int x) { return par[x] == x ? x : (par[x] = find(par[x])); }
    private void union(int a, int b) { int ra = find(a), rb = find(b); if (ra != rb) par[ra] = rb; }
}
