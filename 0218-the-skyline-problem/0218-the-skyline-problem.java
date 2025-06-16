class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> li = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i[] : buildings){
            li.add(new int[]{i[0],-i[2]});
            li.add(new int[]{i[1],i[2]});
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->(b-a));
        q.add(0);
        int prev = 0;
        Collections.sort(li,(a,b)->{
            if(a[0]!=b[0])  return a[0]-b[0];
            return a[1]-b[1];
        });
        for(int i[] : li){
            if(i[1]<0){
                q.add(-i[1]);
            }
            else{
                q.remove(i[1]);
            }
            int ele = q.peek();
            if(ele!=prev){
                res.add(Arrays.asList(i[0],ele)  );
                prev = ele;
            }
        }
        return res;
    }
}