/*
 * Problem: Palindrome Linked List.
 *
 * Intuition: Find middle, reverse second half, walk both halves comparing.
 * Time: O(n)  Space: O(1)
 */
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
public class PalindromeLL {
    public boolean isPalindrome(ListNode h) {
        ListNode s = h, f = h;
        while (f != null && f.next != null) { s = s.next; f = f.next.next; }
        ListNode prev = null, cur = s;
        while (cur != null) { ListNode t = cur.next; cur.next = prev; prev = cur; cur = t; }
        ListNode a = h, b = prev;
        while (b != null) { if (a.val != b.val) return false; a = a.next; b = b.next; }
        return true;
    }
}
