/*
 * Problem: Max XOR with an Element From Array (queries with constraint a[i] <= m_i).
 *
 * Intuition: Sort queries by m and array; insert nums <= m_i into trie before each query.
 * Time: O((n+q) log + (n+q)*32)  Space: O(n*32)
 */
import java.util.*;
public class MaxXORWithElementFromArray {
    class Node { Node[] ch = new Node[2]; }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int q = queries.length;
        Integer[] idx = new Integer[q];
        for (int i = 0; i < q; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> queries[a][1] - queries[b][1]);
        int[] res = new int[q];
        Node root = new Node();
        int ni = 0;
        for (int i : idx) {
            int x = queries[i][0], m = queries[i][1];
            while (ni < nums.length && nums[ni] <= m) { insert(root, nums[ni++]); }
            if (ni == 0) res[i] = -1;
            else res[i] = query(root, x);
        }
        return res;
    }
    private void insert(Node r, int x) {
        Node n = r;
        for (int i = 31; i >= 0; i--) {
            int b = (x >> i) & 1;
            if (n.ch[b] == null) n.ch[b] = new Node();
            n = n.ch[b];
        }
    }
    private int query(Node r, int x) {
        Node n = r; int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int b = (x >> i) & 1, want = 1 - b;
            if (n.ch[want] != null) { xor |= (1 << i); n = n.ch[want]; }
            else n = n.ch[b];
        }
        return xor;
    }
}
