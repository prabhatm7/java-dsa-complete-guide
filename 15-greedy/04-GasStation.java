// LC 134. Gas Station
// Approach: If total gas >= total cost, solution exists. Track current tank; reset start when tank < 0.
// Time: O(n) | Space: O(1)
class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0, currTank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalTank += diff;
            currTank += diff;
            if (currTank < 0) {
                start = i + 1;
                currTank = 0;
            }
        }
        return totalTank >= 0 ? start : -1;
    }
}
