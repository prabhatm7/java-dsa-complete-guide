// LC 269. Alien Dictionary
// Approach: Build directed graph from adjacent word comparisons. Topological sort (BFS/Kahn's).
// Time: O(C) where C = total chars in all words | Space: O(1) for 26 letters
import java.util.*;

class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String w : words) for (char c : w.toCharArray()) { graph.putIfAbsent(c, new HashSet<>()); indegree.putIfAbsent(c, 0); }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (graph.get(w1.charAt(j)).add(w2.charAt(j)))
                        indegree.merge(w2.charAt(j), 1, Integer::sum);
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (var entry : indegree.entrySet()) if (entry.getValue() == 0) queue.offer(entry.getKey());
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char next : graph.get(c)) {
                indegree.merge(next, -1, Integer::sum);
                if (indegree.get(next) == 0) queue.offer(next);
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
