class Solution {
    public boolean checkIfExist(int[] arr) {
        // Arrays.sort(arr);
        Set<Integer> map = new HashSet<>();
        for(int i : arr){
            // if(!((i&1)>0)){
                if(map.contains(i<<1) ){
                    return true;
                }
                else if(!((i&1)>0) && map.contains(i>>1)){
                    return true;
                }
            // }
            map.add(i);
        }
        return false;
    }
}