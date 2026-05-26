/*
 * Problem: Queue using array (circular).
 *
 * Intuition: Head and tail indices; modulo for wrap-around.
 * Time: O(1) per op  Space: O(n)
 */
public class QueueUsingArray {
    int[] a; int head = 0, tail = 0, sz = 0, cap;
    public QueueUsingArray(int c) { cap = c; a = new int[c]; }
    public void offer(int x) { a[tail] = x; tail = (tail + 1) % cap; sz++; }
    public int poll() { int x = a[head]; head = (head + 1) % cap; sz--; return x; }
    public int peek() { return a[head]; }
    public boolean isEmpty() { return sz == 0; }
    public int size() { return sz; }
}
