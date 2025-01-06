class Solution {
    public int[] minOperations(String s) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='1'){
                set.add(i);
            }
        }
        int ans[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int temp = 0;
            for(int j: set){
                temp = temp + Math.abs(j-i);
            }
            ans[i] = temp;
        }
        return ans;
    }
}