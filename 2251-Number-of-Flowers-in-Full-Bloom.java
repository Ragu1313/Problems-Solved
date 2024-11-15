class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<flowers.length;i++){
            int start = flowers[i][0];
            int end = flowers[i][1];
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end+1,map.getOrDefault(end+1,0)-1);
        }
        PriorityQueue<int []> p = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<people.length;i++){
            p.add( new int[] {people[i],i});
        } 
        int sum = 0;
        int res [] = new int[people.length];
        for(int i : map.keySet()){
            // sum = sum + map.get(i);
            while(!p.isEmpty() && p.peek()[0]<i){
                int temp [] = p.poll();
                res[temp[1]] = sum;
            }
            sum = sum+map.get(i);
            // if()
        }
        return res;
    }
}