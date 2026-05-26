/*
 * Problem: Accounts Merge.
 *
 * Intuition: DSU on email indices; map email->idx; union all emails in each account; group by root.
 * Time: O(N*A*log)  Space: O(N*A)
 */
import java.util.*;
public class AccountsMerge {
    int[] par;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        par = new int[n];
        for (int i = 0; i < n; i++) par[i] = i;
        Map<String, Integer> emailToIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String e = accounts.get(i).get(j);
                if (emailToIdx.containsKey(e)) union(i, emailToIdx.get(e));
                else emailToIdx.put(e, i);
            }
        }
        Map<Integer, TreeSet<String>> g = new HashMap<>();
        for (Map.Entry<String, Integer> e : emailToIdx.entrySet())
            g.computeIfAbsent(find(e.getValue()), k -> new TreeSet<>()).add(e.getKey());
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> e : g.entrySet()) {
            List<String> a = new ArrayList<>();
            a.add(accounts.get(e.getKey()).get(0));
            a.addAll(e.getValue());
            res.add(a);
        }
        return res;
    }
    private int find(int x) { return par[x] == x ? x : (par[x] = find(par[x])); }
    private void union(int a, int b) { int ra = find(a), rb = find(b); if (ra != rb) par[ra] = rb; }
}
