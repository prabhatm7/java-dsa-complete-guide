/*
 * Problem: Toggle the i-th bit.
 *
 * Intuition: n ^ (1 << i).
 * Time: O(1)  Space: O(1)
 */
public class ToggleIthBit {
    public int toggle(int n, int i) { return n ^ (1 << i); }
}
