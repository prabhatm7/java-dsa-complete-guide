/*
 * Problem: Minimum Spanning Tree using Prim's.
 *
 * Intuition: PQ of (weight, node); start from 0; greedily add cheapest edge connecting MST to non-MST.
 * Time: O(E log V)  Space: O(V)
 */
import java.util.*;
public class PrimsMST {
    public int mst(int V, List<List<int[]>> adj) {
        boolean[] inMST = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            if (inMST[c[1]]) continue;
            inMST[c[1]] = true;
            sum += c[0];
            for (int[] e : adj.get(c[1])) if (!inMST[e[0]]) pq.offer(new int[]{e[1], e[0]});
        }
        return sum;
    }
}
