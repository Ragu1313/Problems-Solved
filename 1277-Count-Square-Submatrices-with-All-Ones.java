class Solution {
    public int countSquares(int[][] mat) {
        int res = 0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(i==0 || j==0 || mat[i][j]==0){
                    continue;
                }
                
                int left = 0;
                if(i-1>=0){
                    left = mat[i-1][j];
                }
                int top = 0;
                if(j-1>=0){
                    top = mat[i][j-1];
                }
                int dia = 0;
                if(i-1>=0 && j-1>=0){
                    dia = mat[i-1][j-1];
                }
                mat[i][j] = Math.min(left,Math.min(top,dia))+1;
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                res = res+mat[i][j];
            }
        }
        return res;
    }
}