/*
 * Problem: String to Integer (atoi) with overflow clamp.
 *
 * Intuition: Skip spaces, parse sign, read digits with overflow check against Integer.MAX/MIN.
 * Time: O(n)  Space: O(1)
 */
public class AtoiImplementation {
    public int myAtoi(String s) {
        int i = 0, n = s.length(), sign = 1, ans = 0;
        while (i < n && s.charAt(i) == ' ') i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) sign = s.charAt(i++) == '-' ? -1 : 1;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int d = s.charAt(i) - '0';
            if (ans > (Integer.MAX_VALUE - d) / 10) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            ans = ans * 10 + d; i++;
        }
        return ans * sign;
    }
}
