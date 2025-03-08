class Solution {
    public int f(int i,int j){
        int cnt = 1;
        // int res = 0;
        while(i>=cnt){
            if(i>=cnt){
                i = i-cnt;cnt++;
            }
            if(j>=cnt){
                j = j-cnt;cnt++;
            }
            else{
                break;
            }
        }
        return cnt-1;
    }
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(f(red,blue),f(blue,red));
    }
}