/*
 * Problem: Print "Hello" n times using recursion.
 *
 * Intuition: Base case at 0; recursive call decrementing n.
 * Time: O(n)  Space: O(n)
 */
public class PrintNTimes {
    public void print(int n) {
        if (n == 0) return;
        System.out.println("Hello");
        print(n - 1);
    }
}
