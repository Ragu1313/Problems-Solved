class Solution {

    public int f(int ii,int m,int mat[][]){
        int maxi = mat[0][ii];
        int index =0;
        for(int i=1;i<m;i++){
            if(maxi<mat[i][ii]){
                index = i;
                maxi = mat[i][ii];
            }
        }
        return index;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int l = 0;
        int h = m-1;
        int row = 0;
        while(l<=h){
            int mid = l+(h-l)/2;
            row = f(mid,n,mat);
            int left = mid-1>=0 ?mat[row][mid-1]:-1;
            int right = mid+1<m ?mat[row][mid+1]:-1;
            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[]{row,mid};
            }
            else if (mat[row][mid] < left){    
                h = mid-1;    
            }
            else if(mat[row][mid] < right){
                l = mid+1; 
            }
        }
        return new int[]{-1,-1};
    }
}