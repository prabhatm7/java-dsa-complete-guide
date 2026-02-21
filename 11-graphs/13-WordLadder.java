// LC 127. Word Ladder
// Approach: BFS. From beginWord, try changing each char to a-z. If in wordList, add to queue.
// Time: O(m^2 * n) where m = word length, n = wordList size | Space: O(m^2 * n)
import java.util.*;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] word = queue.poll().toCharArray();
                for (int j = 0; j < word.length; j++) {
                    char original = word[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[j] = c;
                        String newWord = new String(word);
                        if (newWord.equals(endWord)) return level + 1;
                        if (wordSet.contains(newWord)) {
                            wordSet.remove(newWord);
                            queue.offer(newWord);
                        }
                    }
                    word[j] = original;
                }
            }
            level++;
        }
        return 0;
    }
}
