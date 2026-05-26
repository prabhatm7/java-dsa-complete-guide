/*
 * Problem: Length of Cycle in LL.
 *
 * Intuition: Once slow/fast meet, fix one and walk the other until they meet again, counting.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class LengthOfCycle {
    public int cycleLen(ListNode h) {
        ListNode s = h, f = h;
        while (f != null && f.next != null) {
            s = s.next; f = f.next.next;
            if (s == f) {
                int c = 1;
                ListNode t = s.next;
                while (t != s) { c++; t = t.next; }
                return c;
            }
        }
        return 0;
    }
}
