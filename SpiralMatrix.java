class Solution {
    public void spiral(int mat[][],ArrayList<Integer> res){
        // int row = 0;
        // int l = mat.length;
        if (mat == null || mat.length == 0) return;
        int left=0;
        int right=mat[0].length-1;
        int top=0;
        int bottom=mat.length-1;
        // int l= mat.length;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                res.add(mat[top][i]);    
            }
            top++;
            for(int i=top;i<=bottom;i++){
                res.add(mat[i][right]);
            }
            right--;
            if(top<=bottom){
            for(int i=right;i>=left;i--){
                res.add(mat[bottom][i]);
            }
            }
            bottom--;
            if(left<=right){
            for(int i=bottom;i>=top;i--){
                res.add(mat[i][left]);
            }
            left++;
            }
            // l=l-2;
        }
    }
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        spiral(matrix,res);
        return res;
    }
}
