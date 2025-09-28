class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // int size  = 0;
        int right = 0;
        int left = 0;
        int n = arr.length;
        // if(n==1){
        //     return new ArrayList<>(arr[0]);
        // }
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        min.add(0);
        max.add(0);
        right++;
        int res = 0;
        int startind = 0;
        int endind =  1;
        while(right<n){
            //!min.isEmpty() && !max.isEmpty() &&
            while(right<n && arr[max.peekFirst()]-arr[min.peekFirst()]<=x){
                
                while(!min.isEmpty() && arr[min.peekLast()]>arr[right]){
                    min.pollLast();
                }
                min.add(right);
                while(!max.isEmpty() && arr[max.peekLast()]<arr[right]){
                    max.pollLast();
                }
                max.add(right);
                right++;
                int temp = right-left-1;
                if(res<temp){
                    startind  = left;
                    endind = right-1;
                    res = temp;
                }
            }
            while( arr[max.peekFirst()] - arr[min.peekFirst()] > x){
                if(left==max.peekFirst()){
                    max.pollFirst();
                }
                else if(left==min.peekFirst()){
                    min.pollFirst();
                }
                left++;
            }
            int temp = right-left;
            if(res<temp){
                startind  = left;
                endind = right;
                res = temp;
            }
        } 
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=startind;i<endind;i++){
            list.add(arr[i]);
        }
        return list;
    }
}