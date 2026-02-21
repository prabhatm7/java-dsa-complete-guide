// LC 76. Minimum Window Substring
// Approach: Sliding window with two maps. Expand right until valid, then shrink left.
// Track "have" vs "need" count of satisfied characters.
// Time: O(n) | Space: O(n)
import java.util.*;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
       int minLen = Integer.MAX_VALUE;
        int [] freq = new int[256];

        for(char c : t.toCharArray()){
            freq[c]++;
        }

        int cnt = 0;
        int l = 0;
        int start =0;

        for(int r=0; r < s.length(); r++){
            freq[s.charAt(r)] --;

            if(freq[s.charAt(r)] >= 0){
                cnt++;
            }

            while(cnt == t.length()){
                if(minLen > (r - l + 1)){
                    minLen = r - l + 1;
                    start = l;
                }

                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)] > 0){
                    cnt--;
                }

                l++;
            }

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
