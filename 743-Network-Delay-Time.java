public class Pair{
    int val;
    int des;
    public Pair(int val,int des){
        this.val = val;
        this.des = des;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int []>> adj = new ArrayList<>();
        int []res = new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        for(int i=0;i<=n;i++){
            adj.add(new LinkedList<int[]>());
        }
        for(int i=0;i<times.length;i++){
            int src = times[i][0];
            int des = times[i][1];
            int w = times[i][2];  
            adj.get(src).add(new int[]{des,w});
        }
        res[k] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });
        q.add(new Pair(0,k));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int wei = temp.val;
            int dest = temp.des;
            List<int[]> arr = adj.get(dest);
            for(int i=0;i<arr.size();i++){
                int arr1[] = arr.get(i);
                if(wei+arr1[1]<res[arr1[0]]){
                    q.add(new Pair(wei+arr1[1],arr1[0]));
                    res[arr1[0]] = wei+arr1[1];
                }
            }
            // q.add(new Pair())
        }
        int r = 0;
        for(int i=1;i<=n;i++){
            r = Math.max(r,res[i]);
        }
        if(r==Integer.MAX_VALUE)    return -1;
        return r;
    }
}