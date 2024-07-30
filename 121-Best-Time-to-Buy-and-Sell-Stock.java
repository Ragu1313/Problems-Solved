class Solution {
    public int maxProfit(int[] prices) {
        int low,high;
        int i;
        int s=0;
        low = high = prices[0];
        for(i=1;i<prices.length;i++){
            high = prices[i];
            if(high<low ){
                low = high; 
            }
            else if(s<high-low){
            s = high-low;
           }
        }
        return s;
    }
}