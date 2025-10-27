class Solution {
    public int numberOfBeams(String[] bank) {
        int cnt = 0;
        int prev = 0;
        for(String s : bank){
            int temp = 0;
            for(char ch  : s.toCharArray()){
                if(ch=='1'){
                    temp++;
                }
            }
            if(temp>0){
                cnt += prev*temp;
                prev = temp;
            }
        }
        return cnt;
    }
}