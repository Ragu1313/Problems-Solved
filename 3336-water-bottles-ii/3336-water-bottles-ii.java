class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
         int res = numBottles;

        while(numBottles>=numExchange){
            // int temp = (numBottles/numExchange) ;
            // res += temp;
            numBottles -= numExchange ;
            numExchange++;
            res++;
            numBottles += 1;
            // System.out.println(numBottles+" "+numExchange);
        }
        return res;
    }
}