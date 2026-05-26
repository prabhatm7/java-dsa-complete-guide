/*
 * Problem: Majority Element II (> n/3)
 * At most 2 such elements.
 *
 * Intuition: Extended Boyer-Moore with two candidates and two counts; verify in second pass.
 * Time: O(n)  Space: O(1)
 */
import java.util.*;
public class MajorityElementN3 {
    public List<Integer> majorityElement(int[] a) {
        int c1 = 0, c2 = 0, n1 = Integer.MIN_VALUE, n2 = Integer.MIN_VALUE;
        for (int x : a) {
            if (x == n1) c1++;
            else if (x == n2) c2++;
            else if (c1 == 0) { n1 = x; c1 = 1; }
            else if (c2 == 0) { n2 = x; c2 = 1; }
            else { c1--; c2--; }
        }
        List<Integer> res = new ArrayList<>();
        c1 = 0; c2 = 0;
        for (int x : a) { if (x == n1) c1++; else if (x == n2) c2++; }
        int t = a.length / 3;
        if (c1 > t) res.add(n1);
        if (c2 > t) res.add(n2);
        return res;
    }
}
