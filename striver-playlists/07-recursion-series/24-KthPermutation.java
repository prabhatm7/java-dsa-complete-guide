/*
 * Problem: K-th Permutation Sequence of [1..n].
 *
 * Intuition: At each step, block size = (n-1)!; index = k / block; remove digit; iterate.
 * Time: O(n^2)  Space: O(n)
 */
import java.util.*;
public class KthPermutation {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) { fact *= i; nums.add(i); }
        nums.add(n);
        k--;
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(nums.remove(k / fact));
            k %= fact;
            if (nums.isEmpty()) break;
            fact /= nums.size();
        }
        return sb.toString();
    }
}
