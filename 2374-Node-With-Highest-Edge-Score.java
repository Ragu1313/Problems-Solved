class Solution {
    public int edgeScore(int[] arr) {
        // Map<Integer,Long> map = new HashMap<>();
        long map[] = new long[arr.length];
        for(int i=0;i<arr.length;i++){
            // map.put(arr[i],Long.valueOf(0));
            map[arr[i]] = Long.valueOf(0);
        }
        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            // map.put(temp,Long.valueOf(map.get(temp)+i));
            map[temp] = Long.valueOf(map[temp]+i);
        }
        long res = -1;
        int index = -2;
        for(int set=0;set<arr.length;set++){
            // if(map.containsKey(set)){
                if(res<map[set]){
                    index = set;
                    res = map[set];
                }
            // }
        }
        return index;
    }
}