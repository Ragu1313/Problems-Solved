class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0)   return new int[0];
        Map<Integer,Integer> map = new HashMap<>();
        int res[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            // map.put(arr[i],-1);
            res[i] = arr[i];
        }
        Arrays.sort(arr);
        map.put(arr[0],1);
        int c = 2;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]!=arr[i]){
                map.put(arr[i],c++);
            }
        }
        for(int i=0;i<res.length;i++){
            arr[i] = map.get(res[i]);
        }
        return arr;
    }
}