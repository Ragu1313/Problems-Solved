class Pair{
    int val;
    int ind;
    public Pair(int val,int ind){
        this.val = val;
        this.ind = ind;
    }
}
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0])   return a[0]-b[0];
            return a[1]-b[1];
        });
        Pair arr[] = new Pair[queries.length];
        for(int i=0;i<queries.length;i++){
            arr[i] = new Pair(queries[i],i);
        }
        Arrays.sort(arr,(a,b)->{
            if(a.val!=b.val)  return a.val-b.val;
            return a.ind-b.ind;
        });
        int j  = 0;
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])  return a[0]-b[0];
            return a[1] - b[1];
        });
        int res[] = new int[arr.length];
        Arrays.fill(res,-1);
        for(int i=0;i<arr.length;i++){
            while(j<intervals.length){
                int temp[] = intervals[j];
                int start = temp[0];
                int end = temp[1];
                if(arr[i].val>=start){
                    p.add(new int[]{end-start+1 ,end});
                }
                else break;
                j++;
            }
            while(!p.isEmpty() && p.peek()[1]<arr[i].val){
                p.poll();
            }
            if(!p.isEmpty()){
                res[arr[i].ind] = p.peek()[0];
            }
        }
        
        return res;
    }
}