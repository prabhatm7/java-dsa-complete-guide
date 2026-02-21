// LC 55. Jump Game
// Approach: Track farthest reachable index. If current index > farthest, can't proceed.
// Time: O(n) | Space: O(1)
class JumpGame {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) return false;
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }
}
