/*
 * Problem: Find all triplets in a sorted Doubly Linked List with given sum.
 *
 * Intuition: Two pointers (head, tail) after fixing each node as smallest; classic two-sum in DLL.
 * Time: O(n^2)  Space: O(1)
 */
import java.util.*;
class DNode15b { int val; DNode15b prev, next; DNode15b(int v){val=v;} }
public class TripletDLL {
    public List<int[]> triplets(DNode15b head, int target) {
        List<int[]> res = new ArrayList<>();
        for (DNode15b a = head; a != null; a = a.next) {
            DNode15b l = a.next, r = a;
            while (r != null && r.next != null) r = r.next;
            while (l != null && r != null && l != r && l.prev != r) {
                int s = a.val + l.val + r.val;
                if (s == target) { res.add(new int[]{a.val, l.val, r.val}); l = l.next; r = r.prev; }
                else if (s < target) l = l.next;
                else r = r.prev;
            }
        }
        return res;
    }
}
