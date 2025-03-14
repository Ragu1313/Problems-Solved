class Solution {
   
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int dif[] = new int[n];
        // if(st[0]==0)    return 0;
        int pre = 0;
        int ind = 0;
        for(int i=0;i<n;i++){
            while(pre + dif[i]<nums[i]){
                if(ind==queries.length) return -1;
                int start = queries[ind][0];
                int end = queries[ind][1];
                int val = queries[ind][2];
                ind++;
                if(end<i)   continue;
                if(end<n-1)    dif[end+1] -= val;
                dif[Math.max(start,i)] += val;    
                
                // System.out.println(pre+dif[i]);
            }
            pre += dif[i];
            
        }
        return ind;

    }
}