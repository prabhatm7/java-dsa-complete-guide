// LC 45. Jump Game II
// Approach: BFS-like. Track current jump's end and farthest reachable. Increment jumps when reaching end.
// Time: O(n) | Space: O(1)
class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0, end = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}
