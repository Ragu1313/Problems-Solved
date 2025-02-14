class Solution {
    public int f(Queue<int[]> q , int in[],List<List<Integer>> adj,int time[],int lasttime[]){
        
        while(!q.isEmpty()){
            int temp[] = q.poll();
            int node = temp[0];
            int val = temp[1];
            for(int i : adj.get(node)){
                in[i]--;
                int maxval = Math.max(lasttime[i],lasttime[node]+time[i-1]);
                lasttime[i] = maxval;
                if(in[i]==0){
                    q.add(new int[]{i,maxval});
                }
            }
        }
        int res = 0 ;
        for(int i:lasttime ){
            res = Math.max(res,i);
        }
        return res;
    }
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        int in[] = new int[n+1] ;
        int lasttime[] = new int[n+1];
        // int vis[] = new int[]
        for(int [] i : relations){
            in[i[1]]++;
            adj.get(i[0]).add(i[1]);
        }
        // int  arr [] = {1,2,3}
        Queue<int[]> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(in[i]==0)  {
                q.add(new int[]{i,time[i-1]});
                lasttime[i] = time[i-1];
            }  
        }
        return f(q,in,adj,time,lasttime);
        // return  0;
    }
}