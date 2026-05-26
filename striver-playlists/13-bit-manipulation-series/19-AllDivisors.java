/*
 * Problem: All divisors of n.
 *
 * Intuition: Iterate i to sqrt(n); add i and n/i when divisible.
 * Time: O(sqrt n)  Space: O(d)
 */
import java.util.*;
public class AllDivisors {
    public List<Integer> divisors(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; (long) i * i <= n; i++) {
            if (n % i == 0) {
                res.add(i);
                if (i != n / i) res.add(n / i);
            }
        }
        Collections.sort(res);
        return res;
    }
}
