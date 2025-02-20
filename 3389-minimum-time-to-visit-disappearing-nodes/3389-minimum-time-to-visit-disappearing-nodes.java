class Pair{
    int val;
    int node;
    Pair(int val,int node){
        this.node = node;
        this.val = val;
    }
}

class Solution {
    public int[] f(List<List<Pair>> adj,int []  disappear,int n){
        int distance[] = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        int vis[] = new int[n];
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        if( disappear[0]>0)  { 
            p.add(new int[]{0,0});
            distance[0] = 0;
            
        }
        while(!p.isEmpty()){
            int temp[] = p.poll();
            int val = temp[0];
            int node = temp[1];
            if(vis[node]==1)   continue;
            vis[node] = 1;
            for(Pair i : adj.get(node)){
                if(vis[i.node]==1)    continue;
                int tempval = val+i.val;
                if( disappear[i.node]>tempval && distance[i.node]>tempval){
                    distance[i.node] = tempval;
                    // vis[i.node] = 1; 
                    p.add(new int[]{tempval,i.node});
                }
            }
        }
        for(int i=0;i<n;i++){
            if(distance[i]==Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }
        return distance;

    }
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }
        int n1 = edges.length;
        for(int i=0;i<n1;i++){
            int src = edges[i][0];
            int des = edges[i][1];
            int wei = edges[i][2];
            adj.get(src).add(new Pair(wei,des));
            adj.get(des).add(new Pair(wei,src));
        }
        return f(adj,disappear,n);
    }
}