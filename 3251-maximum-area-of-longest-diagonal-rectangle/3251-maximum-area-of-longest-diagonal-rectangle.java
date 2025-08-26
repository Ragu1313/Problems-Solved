class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int res = 0;
        double maxi = 0;
        for(int i[] : dimensions){
            double temp = Math.sqrt( (  (i[0]*i[0])+ (i[1]*i[1]) ) );
            if(maxi ==  temp){
                maxi = temp;
                res = Math.max(res,i[0]*i[1]);
            }
            else if (maxi<temp){
                maxi = temp;
                res = i[0]*i[1];
            }
            
        }
        return res;
    }
}