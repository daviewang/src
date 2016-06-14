import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Comparator;

public class O355Twitter {
	private class Tweet {
		int time;
		int id;
		public Tweet(int time, int id) {
			this.time = time;
			this.id = id;
		}
	}
	int timeStamp;
	
	// User ID, followed people
	Map<Integer, Set<Integer>> fans;
	// User ID, tweet owned by this user
	Map<Integer, LinkedList<Tweet>> tweets;
	 /** Initialize your data structure here. */
    public O355Twitter() {
        timeStamp = 0;
		fans = new HashMap<>();
		tweets = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!fans.containsKey(userId)) {
			fans.put(userId, new HashSet<>());
		}
		fans.get(userId).add(userId);
		if (!tweets.containsKey(userId)) {
			tweets.put(userId, new LinkedList<>());
		}
		tweets.get(userId).addFirst(new Tweet(timeStamp++, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
		List<Integer> res = new LinkedList<>();
        if (!fans.containsKey(userId)) return res;
		Comparator<Tweet> cp = new Comparator<Tweet>() {
			public int compare(Tweet a, Tweet b) {
				return b.time - a.time;
			}
		};
		PriorityQueue<Tweet> feed = new PriorityQueue<>(10, cp);
		Set<Integer> people = fans.get(userId);
		for (Integer p : people) {
			List<Tweet> tweetList = tweets.get(p);
			if (tweetList != null && tweetList.size() != 0)
				feed.addAll(tweetList);
		}
		while (feed.size() > 0 && res.size() < 10) {
			res.add(feed.poll().id);
		}
		return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
		if (!fans.containsKey(followerId)) {
			fans.put(followerId, new HashSet<>());
		}
		fans.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (fans.containsKey(followerId) && followerId != followeeId) {
			fans.get(followerId).remove(followeeId);
		}
    }
}