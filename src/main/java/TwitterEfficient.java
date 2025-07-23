import java.util.*;

// https://leetcode.com/problems/design-twitter/description/
public class TwitterEfficient {
    static int counter = 0;

    private class Tweet {
        int tweetId;
        int userId;
        int time;

        public Tweet(int tweetId, int userId) {
            time = ++counter;
            this.tweetId = tweetId;
            this.userId = userId;
        }
    }
    HashMap<Integer,  LinkedList<Tweet>> tweets;
    HashMap<Integer, HashSet<Integer>> followers;

    public TwitterEfficient() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        LinkedList<Tweet> userTweets = tweets.getOrDefault(userId, new LinkedList<Tweet>());
        userTweets.add(0, new Tweet(tweetId, userId));
        tweets.put(userId, userTweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> followingThese = followers.getOrDefault(userId, new HashSet<>());
        followingThese.add(userId);

        HashMap<Integer, ListIterator<Tweet>> listIterators = new HashMap<>();

        for (Integer user: followingThese) {
            listIterators.put(user, tweets.getOrDefault(user, new LinkedList<>()).listIterator());
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        for ( var iter: listIterators.values()){
            if ( iter.hasNext())
                pq.add(iter.next());
        }

        while (!pq.isEmpty())
        {
            Tweet t = pq.poll();
            result.add(t.tweetId);

            if (listIterators.get(t.userId).hasNext())
                pq.add(listIterators.get(t.userId).next());

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
        TwitterEfficient twitter = new TwitterEfficient();
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
