class Pair{
    int time;
    int val ;
    public Pair(int time,int val){
        this.time = time;
        this.val = val;
    }
}
class Twitter {
    
    Map<Integer,Set<Integer>> follower = new HashMap<>();
    Map<Integer,List<Pair>> post = new HashMap<>();
    int t = 0;
    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        post.putIfAbsent(userId,new ArrayList<>());
        Pair temp = new Pair(t,tweetId);
        t++;
        post.get(userId).add(temp);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.time - a.time);
        follower.putIfAbsent(userId,new HashSet<>());
        // System.out.println(userId+" "+follower.get(userId).size());
        for(int i : follower.get(userId)){
            // System.out.println(i);
            post.putIfAbsent(i,new ArrayList<>());
            List<Pair> arr = post.get(i);
            int n  = arr.size();
            int k = 0;
            for(int j=n-1;j>=0 && k<10;k++,j--){
                pq.add(arr.get(j));
            }
        }
        post.putIfAbsent(userId,new ArrayList<>());
        List<Pair> arr = post.get(userId);
        int n = arr.size();
        int k=0;
        for(int i=n-1;i>=0 && k<10 ;i--,k++){
            pq.add(arr.get(i));
        }
        List<Integer> res = new ArrayList<>();
        k = 0;
        while(k++<10 && !pq.isEmpty() ){
            res.add(pq.peek().val);
            pq.poll();
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        follower.putIfAbsent(followerId,new HashSet<>());
        follower.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        follower.putIfAbsent(followerId,new HashSet<>());
        follower.get(followerId).remove(followeeId);
    }
}
