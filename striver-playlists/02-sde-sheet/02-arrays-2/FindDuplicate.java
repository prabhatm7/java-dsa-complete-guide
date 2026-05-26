/*
 * Problem: Find the Duplicate in N+1 integers (each 1..N)
 *
 * Intuition: Treat array as linked list (index -> a[index]); cycle exists; Floyd's tortoise & hare finds entry of cycle.
 * Time: O(n)  Space: O(1)
 */
public class FindDuplicate {
    public int findDuplicate(int[] a) {
        int slow = a[0], fast = a[0];
        do { slow = a[slow]; fast = a[a[fast]]; } while (slow != fast);
        slow = a[0];
        while (slow != fast) { slow = a[slow]; fast = a[fast]; }
        return slow;
    }
}
