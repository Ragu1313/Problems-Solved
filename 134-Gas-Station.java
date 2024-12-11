class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int arr[] = new int[gas.length];
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<gas.length;i++){
            // if(gas[i])
            sum1+=gas[i];
            sum2+=cost[i];
        }
        if(sum1-sum2<0){
            return -1;
        }
        int res = -1;
        int prev = 0;
        for(int i=0;i<gas.length;i++){
            int temp = gas[i]-cost[i]+prev;

            if(temp>=0){
                if(res==-1){
                    res = i;    
                }
                prev = temp;
            }
            else{
                res = -1;
                prev = 0;
            }
            // System.out.println(i+ \ \+prev +\ \+temp);
        }
        return res;
    }
}