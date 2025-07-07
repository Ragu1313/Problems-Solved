class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->{
            if(a[0]!=b[0])   return a[0]-b[0];
            return a[1] - b[1];
        });
        int cnt = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>();
        int j = 0;
        int n = events.length;
        for(int i=1;i<=100000;i++){
            while(!p.isEmpty() && p.peek()<i) p.poll();
            // if(j<n){
            while(j<n && events[j][0]<=i){
                p.add(events[j][1]);
                j++;
            }
            if(!p.isEmpty()){
                p.poll();
                cnt++;
            }
        }
        return cnt;
    }
}
