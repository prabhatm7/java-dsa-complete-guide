/*
 * Problem: Word Ladder II — return all shortest transformation sequences.
 *
 * Intuition: BFS to find shortest distances; then DFS from end backward following decreasing distance to reconstruct paths.
 * Time: Exponential in worst case  Space: O(N*L)
 */
import java.util.*;
public class WordLadderII {
    Map<String, Integer> dist = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> findLadders(String begin, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(end)) return ans;
        dist.put(begin, 0);
        Queue<String> q = new LinkedList<>(); q.offer(begin);
        while (!q.isEmpty()) {
            String w = q.poll();
            int d = dist.get(w);
            char[] arr = w.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char o = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String nx = new String(arr);
                    if (dict.contains(nx) && !dist.containsKey(nx)) { dist.put(nx, d + 1); q.offer(nx); }
                }
                arr[i] = o;
            }
        }
        if (!dist.containsKey(end)) return ans;
        List<String> path = new ArrayList<>(); path.add(end);
        dfs(end, begin, path);
        return ans;
    }
    private void dfs(String w, String begin, List<String> path) {
        if (w.equals(begin)) {
            List<String> r = new ArrayList<>(path);
            Collections.reverse(r);
            ans.add(r);
            return;
        }
        int d = dist.get(w);
        char[] arr = w.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char o = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                String pre = new String(arr);
                if (dist.getOrDefault(pre, -1) == d - 1) {
                    path.add(pre);
                    dfs(pre, begin, path);
                    path.remove(path.size() - 1);
                }
            }
            arr[i] = o;
        }
    }
}
