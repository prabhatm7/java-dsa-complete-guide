/*
 * Problem: Clone Graph (undirected, connected).
 *
 * Intuition: DFS with HashMap original->clone; build clones lazily and recurse on neighbors.
 * Time: O(V+E)  Space: O(V)
 */
import java.util.*;
class GNode { int val; List<GNode> neighbors; GNode(int v){val=v;neighbors=new ArrayList<>();} }
public class CloneGraph {
    Map<GNode, GNode> map = new HashMap<>();
    public GNode cloneGraph(GNode node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        GNode c = new GNode(node.val);
        map.put(node, c);
        for (GNode nb : node.neighbors) c.neighbors.add(cloneGraph(nb));
        return c;
    }
}
