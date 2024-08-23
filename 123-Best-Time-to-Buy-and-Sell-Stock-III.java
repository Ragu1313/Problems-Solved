class Solution {
    public int maxProfit(int[] arr) {
        int next [][] = new int [2][3];
        int cur [][] = new int[2][3];
        int m;
        for(int i=arr.length-1;i>=0;i--){
            for(int flag=0;flag<2;flag++){
                for(int count=0;count<2;count++){
                    if(flag==0)
                        m = Math.max(next[1][count]-arr[i],next[0][count]);
                    else
                        m = Math.max(next[0][count+1]+arr[i],next[1][count]);
                    cur[flag][count] = m;
                }
                cur = next;
            }
        }
        return cur[0][0];
    }
}