// LC 138. Copy List with Random Pointer
// Approach: HashMap mapping original -> copy. Two passes: create nodes, then set next/random.
// Time: O(n) | Space: O(n)
import java.util.*;

class CopyListWithRandomPointer {
    static class Node { int val; Node next, random; Node(int v) { val = v; } }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}
