// LC 84. Largest Rectangle in Histogram
// Approach: Monotonic increasing stack of indices. On pop, calculate area with popped as shortest bar.
// Width = current_index - stack_top - 1 (or current_index if stack empty)
// Time: O(n) | Space: O(n)
import java.util.*;

class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
