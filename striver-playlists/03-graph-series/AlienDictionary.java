
/*
 * Problem: Alien Dictionary — derive char ordering from sorted-in-alien-order list of words.
 *
 * Intuition: Compare adjacent words for first differing char => directed edge; topological sort.
 * Time: O(N*L + K)  Space: O(K)
 */
import java.util.*;

public class AlienDictionary {
    public String findOrder(String[] words, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++)
            adj.add(new ArrayList<>());
        
        int[] in = new int[k];
        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i], b = words[i + 1];
            int len = Math.min(a.length(), b.length()), j = 0;
            while (j < len && a.charAt(j) == b.charAt(j))
                j++;
            if (j == len) {
                if (a.length() > b.length())
                    return "";
                continue;
            }
            adj.get(a.charAt(j) - 'a').add(b.charAt(j) - 'a');
            in[b.charAt(j) - 'a']++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < k; i++)
            if (in[i] == 0)
                q.offer(i);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append((char) (u + 'a'));
            for (int v : adj.get(u))
                if (--in[v] == 0)
                    q.offer(v);
        }
        return sb.length() == k ? sb.toString() : "";
    }
}
