// LC 133. Clone Graph
// Approach: DFS/BFS with HashMap mapping old node -> cloned node
// Time: O(V+E) | Space: O(V)
import java.util.*;

class CloneGraph {
    static class Node { public int val; public List<Node> neighbors; Node(int v) { val = v; neighbors = new ArrayList<>(); } }

    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (visited.containsKey(node)) return visited.get(node);
        Node clone = new Node(node.val);
        visited.put(node, clone);
        for (Node neighbor : node.neighbors)
            clone.neighbors.add(cloneGraph(neighbor));
        return clone;
    }
}
