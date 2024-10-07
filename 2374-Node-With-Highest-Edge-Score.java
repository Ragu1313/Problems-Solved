class Solution {
    public int edgeScore(int[] arr) {
        Map<Integer,Long> map = new HashMap<>();
        // int res = 0
        // Map<Integer,Integer> map2 = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],Long.valueOf(0));
        }
        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            map.put(temp,Long.valueOf(map.get(temp)+i));
        }
        long res = -1;
        int index = -2;
        for(int set=0;set<arr.length;set++){
            // int set = i;
            if(map.containsKey(set)){
                if(res<map.get(set)){
                    index = set;
                    res = map.get(set);
                }
            }
        }
        return index;
    }
}