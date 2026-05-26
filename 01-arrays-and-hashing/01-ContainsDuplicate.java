// LC 217. Contains Duplicate
// Approach: HashSet - add elements, if already exists return true
// Time: O(n) | Space: O(n)
import java.util.*;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) return true;
        }
        return false;
    }
}

// Status : Practised
// Revison Status : Not Required