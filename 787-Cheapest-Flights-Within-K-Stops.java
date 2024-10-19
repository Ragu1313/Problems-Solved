class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])   return a[0]-b[0];
            return a[1]-b[1];
        });
        int [] res = new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<int[]>());
        }
        for(int i=0;i<flights.length;i++){
            int sr = flights[i][0];
            int de = flights[i][1];
            int val = flights[i][2];
            adj.get(sr).add(new int[]{de,val});
        }
        res[src] = 0;
        pq.add(new int[]{0,0,src});
        while(!pq.isEmpty()){
            int arr[] = pq.poll();
            int k1 = arr[0];
            int weight = arr[1];
            int node = arr[2];
            for(int i=0;i<adj.get(node).size();i++){
                int[] dup = adj.get(node).get(i);
                int des = dup[0];
                int value = dup[1];
                if(des!=dst && k>k1 && weight+value<res[des]){
                    res[des] = weight+value;
                    pq.add(new int[]{k1+1,weight+value,des});
                }  
                else if(des==dst && k>=k1 && weight+value<res[des]){
                    res[des] = weight+value;
                    pq.add(new int[]{k1,weight+value,des});
                }  
            }
        }
        if(res[dst]==Integer.MAX_VALUE) return -1;
        return res[dst];
    }
}