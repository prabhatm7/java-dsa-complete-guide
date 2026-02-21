// LC 981. Time Based Key-Value Store
// Approach: HashMap<String, List<Pair>>. Binary search on timestamp for get.
// Time: set O(1), get O(log n) | Space: O(n)
import java.util.*;

class TimeBasedKeyValueStore {
    private Map<String, List<int[]>> map;
    private Map<String, List<String>> vals;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
        vals = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{timestamp});
        vals.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<int[]> times = map.get(key);
        List<String> values = vals.get(key);
        int l = 0, r = times.size() - 1, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (times.get(mid)[0] <= timestamp) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res == -1 ? "" : values.get(res);
    }
}
