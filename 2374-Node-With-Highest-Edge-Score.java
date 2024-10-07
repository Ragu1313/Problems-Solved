class Solution {
    public int edgeScore(int[] arr) {
        long map[] = new long[arr.length];
        
        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            map[temp]+=i;
        }
        long res = -1;
        int index = -2;
        for(int set=0;set<arr.length;set++){
                if(res<map[set]){
                    index = set;
                    res = map[set];
                }
        }
        return index;
    }
}