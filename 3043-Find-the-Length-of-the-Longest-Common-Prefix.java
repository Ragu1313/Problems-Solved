class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for(int i : arr1){
            while(i>0){
                set.add(i);
                i = i/10;
            }
        }
        int m = 0;
        for(int i:arr2){
            while(i>0){
                if(set.contains(i)){
                    if(m<(int)Math.log10(i)+1){
                        m =Math.max(m,(int) Math.log10(i)+1);
                        break;
                    }
                }
                i = i/10;
            }
        }
        return m;
    }
}