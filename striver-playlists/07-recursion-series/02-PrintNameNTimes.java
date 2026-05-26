/*
 * Problem: Print a Name N Times.
 *
 * Intuition: Backtracking pattern with index increment.
 * Time: O(n)  Space: O(n)
 */
public class PrintNameNTimes {
    public void print(int i, int n, String name) {
        if (i > n) return;
        System.out.println(name);
        print(i + 1, n, name);
    }
}
