class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0;
        long max = 0;
        long pre  = 0;
        int n = differences.length;
        long res = 0;  
        for(int i=0;i<n;i++){
            pre += differences[i];
            min = Math.min(min, pre);
            max = Math.max(max,pre);
        }
        if(upper-lower<max-min)    return 0;
        return (int)(upper-lower+1-(max-min));
    }
} 