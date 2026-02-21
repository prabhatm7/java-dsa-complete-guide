// LC 2013. Detect Squares
// Approach: Store point counts in map. For query point, try all points with same x or y to form diagonal.
// Check if other two corners exist.
// Time: add O(1), count O(n) | Space: O(n)
import java.util.*;

class DetectSquares {
    private Map<String, Integer> pointCount = new HashMap<>();
    private List<int[]> points = new ArrayList<>();

    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        pointCount.merge(key, 1, Integer::sum);
        points.add(point);
    }

    public int count(int[] point) {
        int px = point[0], py = point[1], total = 0;
        for (int[] p : points) {
            int qx = p[0], qy = p[1];
            if (Math.abs(px - qx) != Math.abs(py - qy) || px == qx || py == qy) continue;
            total += pointCount.getOrDefault(px + "," + qy, 0) *
                     pointCount.getOrDefault(qx + "," + py, 0);
        }
        return total;
    }
}
