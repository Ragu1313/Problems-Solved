class Solution {
    public int maxFreeTime(int event, int k, int[] start, int[] end) {
        List<Integer> l = new ArrayList<>();
        int prev = 0;
        int n = start.length;
        for(int i=0;i<n;i++){
            int dif = start[i]-prev;
            
            l.add(dif);
            
            prev = end[i];
        }
        
        l.add(event-prev);
        k = k+1;
        int sum = 0;
        int left = 0;
        int n1 = l.size();
        while(left<k && left<n1){
            sum+=l.get(left++);
        }
        // for(int i=0;i<n1;i++){
        //     System.out.println(l.get(i));
        // }
        int res = sum;
        while(left<n1){
            int val = l.get(left-k);
            sum-=val;
            sum+=l.get(left++);
            res = Math.max(sum,res);
        }
        return res;
    }
}