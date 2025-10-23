class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        for(int i[] : points){
            int temp = i[0] * i[0] + i[1] * i[1];
            p.add(new int[]{temp,i[0],i[1]});
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while(k-->0){
            int temp[] = p.poll();
            ArrayList<Integer> dup = new ArrayList<>(Arrays.asList(temp[1],temp[2]) );
            res.add(dup);
        }
        return res;
    }
}