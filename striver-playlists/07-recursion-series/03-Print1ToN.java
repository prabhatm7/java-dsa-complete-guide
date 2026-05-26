/*
 * Problem: Print 1 to N using recursion.
 *
 * Intuition: Print before recursing for ascending order.
 * Time: O(n)  Space: O(n)
 */
public class Print1ToN {
    public void print(int i, int n) {
        if (i > n) return;
        System.out.println(i);
        print(i + 1, n);
    }
}
