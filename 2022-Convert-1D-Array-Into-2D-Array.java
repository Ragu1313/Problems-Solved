class Solution {
    public int[][] construct2DArray(int[] arr, int m, int n) {
        int size = m*n;
        if(size!=arr.length)
            return new int[0][0];
        size = 0;
        int [][] res = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j] = arr[size++];
            }
        }
        return res;
    }
}