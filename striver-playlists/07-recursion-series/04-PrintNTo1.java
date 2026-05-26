/*
 * Problem: Print N to 1.
 *
 * Intuition: Print before decrement, or recurse first then print for backtracking version.
 * Time: O(n)  Space: O(n)
 */
public class PrintNTo1 {
    public void print(int i, int n) {
        if (i < 1) return;
        System.out.println(i);
        print(i - 1, n);
    }
}
