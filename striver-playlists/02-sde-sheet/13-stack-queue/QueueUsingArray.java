/*
 * Problem: Implement Queue using Array (circular).
 *
 * Intuition: Track front/rear with modular arithmetic to avoid shifts.
 * Time: O(1) all ops  Space: O(n)
 */
public class QueueUsingArray {
    int[] arr; int front = 0, rear = -1, size = 0, cap;
    public QueueUsingArray(int n) { cap = n; arr = new int[n]; }
    public void push(int x) { rear = (rear + 1) % cap; arr[rear] = x; size++; }
    public int pop() { int v = arr[front]; front = (front + 1) % cap; size--; return v; }
    public int peek() { return arr[front]; }
    public boolean isEmpty() { return size == 0; }
}
