/*
 * Problem: Stack using array.
 *
 * Intuition: Top pointer; push increments, pop decrements; O(1) ops.
 * Time: O(1) per op  Space: O(n)
 */
public class StackUsingArray {
    int[] a; int top = -1;
    public StackUsingArray(int n) { a = new int[n]; }
    public void push(int x) { a[++top] = x; }
    public int pop() { return a[top--]; }
    public int peek() { return a[top]; }
    public boolean isEmpty() { return top == -1; }
    public int size() { return top + 1; }
}
