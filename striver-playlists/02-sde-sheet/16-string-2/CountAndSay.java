/*
 * Problem: Count and Say.
 *
 * Intuition: Build term n by reading term n-1; count consecutive same chars and append "countDigit".
 * Time: O(2^n)  Space: O(2^n)
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        for (int k = 2; k <= n; k++) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                int j = i;
                while (j < s.length() && s.charAt(j) == s.charAt(i)) j++;
                sb.append(j - i).append(s.charAt(i));
                i = j;
            }
            s = sb.toString();
        }
        return s;
    }
}
