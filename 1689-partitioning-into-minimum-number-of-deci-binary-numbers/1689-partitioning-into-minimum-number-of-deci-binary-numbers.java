class Solution {
    public int minPartitions(String n) {
        int res = 0;
        for(char c : n.toCharArray()){
            int num = Integer.parseInt(c+"");
            if(res<num){
                res = num;
            }
        }
        return res;
    }
}