class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int sum1 = 0;
        int sum2 = 0;
        for(int i : nums1){
            sum1+=i;
        }
        for(int i : nums2){
            sum2+=i;
        }
        if(sum1==sum2)  return 0;
        int minval = 0;
        int maxval = 0;
        if(sum1>sum2){
            for(int i : nums1){
                maxheap.add(i);
            }
            minval = sum2;
            maxval = sum1;
            for(int i : nums2){
                minheap.add(i);
            }
        }
        else{
            for(int i : nums2){
                maxheap.add(i);
            }
            minval = sum1;
            maxval = sum2;
            for(int i : nums1){
                minheap.add(i);
            }
        }
        int cnt = 1;
        while(!minheap.isEmpty() || !maxheap.isEmpty()){
            int dif1 = 0;
            int dif2 = 0;
            if(!minheap.isEmpty() && !maxheap.isEmpty()){
                dif1 = 6 - minheap.peek();
                dif2 = maxheap.peek()-1;
                if(dif1<dif2){
                    minval+=dif2;
                    maxheap.poll();
                }
                else{
                    minval+=dif1;
                    minheap.poll();
                }
            }
            else if(!maxheap.isEmpty()){
                dif2 = maxheap.poll()-1;
                minval+=dif2;
            }
            else{
                dif1 = 6- minheap.poll();
                minval+=dif1;
            }
            if(minval>=maxval)  return cnt;
            cnt++;
        }
        return -1;
    }
}