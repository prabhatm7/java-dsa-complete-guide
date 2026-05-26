/*
 * Problem: Count Primes less than n (Sieve of Eratosthenes).
 *
 * Intuition: Iteratively mark composites starting from each prime's square.
 * Time: O(n log log n)  Space: O(n)
 */
public class CountPrimesSieve {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] notP = new boolean[n];
        int c = 0;
        for (int i = 2; i < n; i++) {
            if (notP[i]) continue;
            c++;
            for (long j = (long) i * i; j < n; j += i) notP[(int) j] = true;
        }
        return c;
    }
}
