class Solution {
    public int minSwapsCouples(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        int cnt = 0;
        for(int i=0;i<n-1;i++){
            int ele = arr[i];
            int next = ele%2==0?ele+1:ele-1;
            if(arr[i+1]!=next){
                cnt++;
                int ind = map.get(next);
                arr[ind] = arr[i+1];
                arr[i+1] = next;
                map.put(arr[ind],ind);
                map.put(arr[i+1],i+1); 
            }
            i++;
        }
        return cnt;
    }
}