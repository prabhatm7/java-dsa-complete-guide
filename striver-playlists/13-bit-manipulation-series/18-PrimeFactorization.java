/*
 * Problem: Prime Factorization of n.
 *
 * Intuition: Trial divide by 2 then odd factors up to sqrt(n); residue is prime if > 1.
 * Time: O(sqrt n)  Space: O(log n)
 */
import java.util.*;
public class PrimeFactorization {
    public List<Integer> primeFactors(int n) {
        List<Integer> res = new ArrayList<>();
        while (n % 2 == 0) { res.add(2); n /= 2; }
        for (int i = 3; (long) i * i <= n; i += 2)
            while (n % i == 0) { res.add(i); n /= i; }
        if (n > 1) res.add(n);
        return res;
    }
}
