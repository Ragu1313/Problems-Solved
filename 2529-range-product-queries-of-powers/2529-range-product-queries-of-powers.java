class Solution {
    
    public int[] productQueries(int n, int[][] queries) {
        int mod = (int)(1e9+7);    
        int arr[] = new int[31];
        // int prev = 1;
        int inx = 0;
        int i = 0;
        while(i<31){
            if( ( (n>>i)&1 )==1){
                // System.out.println(1<<i);
                arr[inx] =  (1<<i);
                // prev = arr[inx];
                inx++; 
            }
            i++;
        }
        int size = queries.length;
        int ans[] = new int[size];
        // for(i=0;i<31;i++){
        //     System.out.print(arr[i]+" ");
        // }
        for(i=0;i<size;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            long temp = 1;
            // if(start==end){
            //     temp = arr[start];
            // }
            for(int j= start;j<=end;j++){
                temp = (temp*arr[j])%mod;
            }
            ans[i] = (int)temp;
        }
        
        return ans;
    }
}