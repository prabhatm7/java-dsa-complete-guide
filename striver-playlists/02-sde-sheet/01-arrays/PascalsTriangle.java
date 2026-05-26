/*
 * Problem: Pascal's Triangle
 * Return first numRows of Pascal's triangle.
 *
 * Intuition: Each row built from previous; row[j] = prev[j-1] + prev[j]. nCr formula for single element.
 * Time: O(n^2)  Space: O(n^2)
 */
import java.util.*;
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) row.add(1);
                else row.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            res.add(row);
        }
        return res;
    }
}
