class Twitter {
    
    Map<Integer,PriorityQueue<int[]>> userTweets;
    Map<Integer,Set<Integer>> userFollows;
    int time;

    public Twitter() {
        time=0;
        userTweets = new HashMap<>();
        userFollows= new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        
        if(!userTweets.containsKey(userId)){
            userTweets.put(userId,new PriorityQueue<int[]>((a,b)-> Integer.compare(b[1],a[1])));
            userFollows.put(userId,new HashSet<>());
        }
    PriorityQueue<int[]> pq = userTweets.get(userId);

    pq.offer(new int[]{tweetId,time++});
    userTweets.put(userId,pq);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(userTweets.isEmpty()){
            return res;
        }

        Set<Integer> set = userFollows.containsKey(userId) ? new HashSet<>(userFollows.get(userId)) : new HashSet<>() ;
        set.add(userId);

        PriorityQueue<int[]> pc = new PriorityQueue<int[]>((a,b)-> Integer.compare(b[1],a[1]));
        for(int userI:set){
            PriorityQueue<int[]> pu = userTweets.containsKey(userI) ? new PriorityQueue<>(userTweets.get(userI)) : new PriorityQueue<int[]>((a,b)-> Integer.compare(b[1],a[1]));
            for(int i=0;i<10;i++){
                if(!pu.isEmpty()){
                    pc.offer(pu.poll());
                }else break;
            }
        }

        for(int i=0;i<10;i++){
            if(!pc.isEmpty()){
                res.add(pc.poll()[0]);
            }else break;
        }


        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> hs = userFollows.containsKey(followerId) ? new HashSet<>(userFollows.get(followerId)) : new HashSet<>() ;

        hs.add(followeeId);

        userFollows.put(followerId,hs);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> hs =userFollows.containsKey(followerId) ? new HashSet<>(userFollows.get(followerId)) : new HashSet<>() ;

        hs.remove(followeeId);

        userFollows.put(followerId,hs);
    }
}
