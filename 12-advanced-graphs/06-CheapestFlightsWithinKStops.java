// LC 787. Cheapest Flights Within K Stops
// Approach: Bellman-Ford for k+1 iterations. Or BFS with pruning.
// Time: O(k * E) | Space: O(V)
import java.util.*;

class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = prices.clone();
            for (int[] f : flights) {
                if (prices[f[0]] != Integer.MAX_VALUE)
                    temp[f[1]] = Math.min(temp[f[1]], prices[f[0]] + f[2]);
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
