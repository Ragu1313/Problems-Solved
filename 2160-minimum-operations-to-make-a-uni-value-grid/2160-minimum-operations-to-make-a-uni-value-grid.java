class Solution {
    public int dif(int arr[],int tar,int x){
        int sum = 0;
        for(int i : arr){
            int rem = Math.abs(i-tar);
            sum += rem/x;
        }
        return sum;
    }
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int  l = n*m;
        int arr[] = new int[l];
        int c = 0;
        int temp = grid[0][0]%x;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[c++] = grid[i][j];
                if(grid[i][j]%x!=temp)  return -1;
            }
        }
        Arrays.sort(arr);
        if(l%2==0){
            int res = dif(arr,arr[l/2],x);
            res = Math.min(res,dif(arr,arr[l/2-1],x));
            return res;
        }
        return dif(arr,arr[l/2],x);

    }
}