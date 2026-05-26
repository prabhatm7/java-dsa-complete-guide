/*
 * Problem: Word Ladder I — shortest transformation length from begin to end.
 *
 * Intuition: BFS; for each word try changing each char to a-z; if in dict, enqueue.
 * Time: O(N * L * 26)  Space: O(N)
 */
import java.util.*;
public class WordLadder {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(end)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        int steps = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                char[] cur = q.poll().toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    char orig = cur[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        cur[j] = c;
                        String nx = new String(cur);
                        if (nx.equals(end)) return steps + 1;
                        if (dict.remove(nx)) q.offer(nx);
                    }
                    cur[j] = orig;
                }
            }
            steps++;
        }
        return 0;
    }
}
