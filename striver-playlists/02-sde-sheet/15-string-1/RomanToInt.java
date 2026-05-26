/*
 * Problem: Roman to Integer.
 *
 * Intuition: If current < next, subtract; else add.
 * Time: O(n)  Space: O(1)
 */
public class RomanToInt {
    public int romanToInt(String s) {
        int[] v = new int[128];
        v['I']=1; v['V']=5; v['X']=10; v['L']=50; v['C']=100; v['D']=500; v['M']=1000;
        int ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && v[s.charAt(i)] < v[s.charAt(i + 1)]) ans -= v[s.charAt(i)];
            else ans += v[s.charAt(i)];
        }
        return ans;
    }
}
