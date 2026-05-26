/*
 * Problem: Implement Stack using Array.
 *
 * Intuition: Maintain top index; push increments, pop returns and decrements.
 * Time: O(1) all ops  Space: O(n)
 */
public class StackUsingArray {
    int[] arr; int top = -1;
    public StackUsingArray(int n) { arr = new int[n]; }
    public void push(int x) { arr[++top] = x; }
    public int pop() { return arr[top--]; }
    public int peek() { return arr[top]; }
    public boolean isEmpty() { return top == -1; }
    public int size() { return top + 1; }
}
