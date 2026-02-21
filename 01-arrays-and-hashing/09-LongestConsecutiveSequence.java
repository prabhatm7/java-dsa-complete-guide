// LC 128. Longest Consecutive Sequence
// Approach: HashSet, only start counting from sequence start (no num-1 in set)
// Time: O(n) | Space: O(n)
import java.util.*;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int longest = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int len = 1;
                while (set.contains(n + len)) len++;
                longest = Math.max(longest, len);
            }
        }
        return longest;
    }
}

