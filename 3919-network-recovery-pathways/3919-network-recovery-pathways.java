class Pair{
    int node;
    int val;
    public Pair(int node,int val){
        this.val = val;
        this.node = node;
    }
}
class Solution {

    public boolean f(int des, long k, int mid, List<List<Pair>> adj, long vis[], boolean[] online) {
        Arrays.fill(vis, Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{0, 0}); // node 0, distance 0
        vis[0] = 0;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int node = (int) cur[0];
            long dist = cur[1];

            if (dist > k) continue; // over budget
            if (node == des) return true; // reached destination
            if (dist > vis[node]) continue; // stale entry

            for (Pair root : adj.get(node)) {
                if (online[root.node] && root.val >= mid) {
                    long newDist = dist + root.val;
                    if (newDist < vis[root.node]) {
                        vis[root.node] = newDist;
                        pq.add(new long[]{root.node, newDist});
                    }
                }
            }
        }
        return false;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        long vis[] = new long[n];
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[] : edges){
            adj.get(i[0]).add(new Pair(i[1],i[2]));
        }
        int low = Integer.MAX_VALUE;
        // int right = Integer.MAX_VALUE;
        int right = 0 ;
        int res = -1;
        for(int i[] : edges){
            right = Math.max(right,i[2]);
            low = Math.min(low,i[2]);
        }
        // System.out.println(right);
        // int res = -1;
        while(low<=right){
            Arrays.fill(vis,Long.MAX_VALUE);
            int mid = low + (right-low)/2;
            // System.out.println(mid);
            if( f(n-1,k,mid,adj,vis,online) ){
                res = mid;
                low = mid+1;
                
            }
            else{
                right = mid-1;
            }
        }   
        return res;
    }
}