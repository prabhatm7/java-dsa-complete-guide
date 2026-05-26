/*
 * Problem: K Max Sum Combinations from two arrays.
 *
 * Intuition: Sort desc; push (0,0) with sum into max-heap; pop k times and push (i+1,j) and (i,j+1) avoiding duplicates with a set.
 * Time: O(k log k)  Space: O(k)
 */
import java.util.*;
public class KMaxSumCombinations {
    public List<Integer> maxCombinations(int[] a, int[] b, int k) {
        Arrays.sort(a); Arrays.sort(b);
        int n = a.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        Set<Long> seen = new HashSet<>();
        pq.offer(new int[]{a[n-1] + b[n-1], n-1, n-1});
        seen.add((long)(n-1) * n + (n-1));
        List<Integer> res = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            res.add(top[0]);
            int i = top[1], j = top[2];
            if (i > 0 && seen.add((long)(i-1) * n + j)) pq.offer(new int[]{a[i-1] + b[j], i-1, j});
            if (j > 0 && seen.add((long)i * n + (j-1))) pq.offer(new int[]{a[i] + b[j-1], i, j-1});
        }
        return res;
    }
}
