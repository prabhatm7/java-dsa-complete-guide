/*
 * Problem: Integer to Roman.
 *
 * Intuition: Greedy with denominations [1000, 900, 500, 400, ..., 1] and matching symbols.
 * Time: O(1)  Space: O(1)
 */
public class IntToRoman {
    public String intToRoman(int n) {
        int[] v = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] s = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v.length; i++) while (n >= v[i]) { sb.append(s[i]); n -= v[i]; }
        return sb.toString();
    }
}
