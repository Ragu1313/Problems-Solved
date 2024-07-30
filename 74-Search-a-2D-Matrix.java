class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j;
        int n = matrix[0].length;
        for(i=0;i<matrix.length;i++){
            if(matrix[i][0]<=target && matrix[i][n-1]>=target){
                int low = 0;
                int high = n-1;
                while(low<=high){
                    int mid = low+(high-low)/2;
                    if(matrix[i][mid]==target)
                        return true;
                    else if(matrix[i][mid]<target)
                        low = mid+1;
                    else
                        high = mid-1;
                }
                return false;
            }  
        }
        return false;
    }
}