// LC 347. Top K Frequent Elements
// Approach: Bucket sort - index = frequency, value = list of nums with that frequency
// Time: O(n) | Space: O(n)
import java.util.*;

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) count.merge(n, 1, Integer::sum);

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) buckets[i] = new ArrayList<>();
        for (var entry : count.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            for (int n : buckets[i]) {
                if (idx < k) res[idx++] = n;
            }
        }
        return res;
    }
}

