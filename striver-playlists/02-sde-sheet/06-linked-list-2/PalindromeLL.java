/*
 * Problem: Palindrome Linked List
 *
 * Intuition: Find middle, reverse second half, compare with first half.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class PalindromeLL {
    public boolean isPalindrome(ListNode head) {
        ListNode s = head, f = head;
        while (f.next != null && f.next.next != null) { s = s.next; f = f.next.next; }
        s.next = reverse(s.next);
        ListNode a = head, b = s.next;
        while (b != null) { if (a.val != b.val) return false; a = a.next; b = b.next; }
        return true;
    }
    private ListNode reverse(ListNode h) {
        ListNode p = null, c = h;
        while (c != null) { ListNode n = c.next; c.next = p; p = c; c = n; }
        return p;
    }
}
