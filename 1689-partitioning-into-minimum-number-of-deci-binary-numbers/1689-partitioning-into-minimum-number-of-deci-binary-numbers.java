class Solution {
    public int minPartitions(String n) {
        int res = 0;
        for(char c : n.toCharArray()){
            int num =  c-'0';
            if(res<num){
                res = num;
            }
        }
        return res;
    }
}