/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */
class Twitter {
    private static class Tweet{
        int tweetId;
        int timestamp;
        public Tweet(int tId,int time){
            tweetId = tId;
            timestamp = time;
        }
    }
    //记录微博发送的时间戳
    private static int timestamp = 0;
    //用户-微博map
    Map<Integer,ArrayList<Tweet>> userTweet = new HashMap<Integer,ArrayList<Tweet>>();
    //用户-关注者map
    Map<Integer,Set<Integer>> userFollowee = new HashMap<Integer,Set<Integer>>();

    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet newT = new Tweet(tweetId,++timestamp);
        if(userTweet.get(userId)==null){
            userTweet.put(userId,new ArrayList());
        }
        userTweet.get(userId).add(newT);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        //插入对象：用户自己的所有微博，用户所有关注者的所有微博
        //顺序：按照发布时间从后往前
        Queue<Tweet> pq = new PriorityQueue<Tweet>((a,b)->(b.timestamp-a.timestamp));
        follow(userId,userId);
        Set<Integer> followees = userFollowee.get(userId);
        
        for(Integer i : followees){
            ArrayList<Tweet> tweets = userTweet.get(i);
            if(tweets != null){
                for(Tweet t : tweets){
                    pq.add(t);
                }
            }
        }
        
        int n=10;
        List<Integer> News = new ArrayList();
        while(n-- > 0 && pq.size()>0){
            News.add(pq.poll().tweetId);
        }
        return News;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userFollowee.containsKey(followerId)){
            userFollowee.put(followerId,new HashSet());
        }
        userFollowee.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userFollowee.containsKey(followerId)){
            userFollowee.put(followerId,new HashSet());
        }
        if(userFollowee.get(followerId).contains(followeeId)){
            userFollowee.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

