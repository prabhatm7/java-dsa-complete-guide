// LC 42. Trapping Rain Water
// Approach: Two pointers with leftMax and rightMax. Process smaller side.
// Water at position = min(leftMax, rightMax) - height[i]
// Time: O(n) | Space: O(1)
class TrappingRainWater {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                leftMax = Math.max(leftMax, height[l]);
                water += leftMax - height[l];
                l++;
            } else {
                rightMax = Math.max(rightMax, height[r]);
                water += rightMax - height[r];
                r--;
            }
        }
        return water;
    }
}
