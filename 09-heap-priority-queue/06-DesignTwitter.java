// LC 355. Design Twitter
// Approach: HashMap for follows, HashMap for tweets with timestamp.
// getNewsFeed: merge k sorted lists using min-heap.
// Time: O(n log k) for feed | Space: O(users * tweets)
import java.util.*;

class DesignTwitter {
    private int timestamp = 0;
    private Map<Integer, List<int[]>> tweets = new HashMap<>();
    private Map<Integer, Set<Integer>> follows = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{timestamp++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        follows.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for (int followee : follows.get(userId)) {
            List<int[]> userTweets = tweets.getOrDefault(followee, new ArrayList<>());
            for (int[] t : userTweets) maxHeap.offer(t);
        }
        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty() && res.size() < 10) {
            res.add(maxHeap.poll()[1]);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) follows.get(followerId).remove(followeeId);
    }
}
