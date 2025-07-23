import java.util.*;

// https://leetcode.com/problems/design-twitter/description/
public class Twitter {
    static class Tweet {
        int tweetId;
        int userId;

        public Tweet(int tweetId, int userId) {
            this.tweetId = tweetId;
            this.userId = userId;
        }
    }
    List<Tweet> tweets;
    HashMap<Integer, HashSet<Integer>> followers;

    public Twitter() {
        tweets = new LinkedList<>();
        followers = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(tweetId, userId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> followingThese = followers.getOrDefault(userId, new HashSet<>());
        followingThese.add(userId);

        ListIterator<Tweet> listIterator = tweets.listIterator(tweets.size());

        while ( listIterator.hasPrevious())
        {
            Tweet t = listIterator.previous();
            if (followingThese.contains(t.userId)) {
                result.add(t.tweetId);
            }
            if (result.size() == 10)
                break;
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        HashSet<Integer> followingThese = followers.getOrDefault(followerId, new HashSet<Integer>());
        followingThese.add(followeeId);
        followers.put(followerId, followingThese);
    }

    public void unfollow(int followerId, int followeeId) {
        followers.getOrDefault(followerId, new HashSet<Integer>()).remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        List<Integer> tweets = twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        System.out.println(" Initital Tweets :" + tweets.toString());
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        tweets = twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        System.out.println(" Updated1 Tweets :" + tweets.toString());
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        tweets = twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
        System.out.println(" Updated2 Tweets :" + tweets.toString());
    }
}
