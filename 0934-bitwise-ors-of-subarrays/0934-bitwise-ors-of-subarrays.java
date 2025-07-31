class Solution {
    
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            Set<Integer> set1 = new HashSet<>();
            set1.add(arr[i]);
            for(int j : prev){
                set1.add(j|arr[i]);
            }
            prev = set1;
            set.addAll(prev);
        }
        return set.size();
    }
}