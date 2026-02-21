// LC 853. Car Fleet
// Approach: Sort by position desc. Calculate time to reach target.
// If current time <= previous fleet time, they merge. Otherwise new fleet.
// Time: O(n log n) | Space: O(n)
import java.util.*;

class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) cars[i] = new int[]{position[i], speed[i]};
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        int fleets = 0;
        double prevTime = 0;
        for (int[] car : cars) {
            double time = (double)(target - car[0]) / car[1];
            if (time > prevTime) {
                fleets++;
                prevTime = time;
            }
        }
        return fleets;
    }
}
