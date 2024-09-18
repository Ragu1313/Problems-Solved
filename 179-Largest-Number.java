class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        int i;
        String[] s = new String[n];
        for (i=0;i<n;i++){
            s[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s,(x,y)->(y+x).compareTo((x+y)));
        StringBuilder sh = new StringBuilder();
        for(String o :s){
            sh.append(o);
        }
        String result = sh.toString();
        return result.startsWith("0")?"0":result;
    }
}