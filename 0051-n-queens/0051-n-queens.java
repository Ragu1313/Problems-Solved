class Solution {
    public static List<String> print(int mat[][],int n){
        List<String> a =new ArrayList<>();
        for(int i=0;i<n;i++){
            String s = "";
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    s+="Q";
                }
                else    
                    s+=".";
            }
            a.add(s);
        }
        return a;
    }
    public static boolean check(int mat[][] , int col,int row,int n){
        for(int i=0;i<col;i++){
            if(mat[row][i]==1)
                return false;
        }
        int r = row-1;
        for(int i=col-1;i>=0;i--){
            if(r==-1) break;
            if(mat[r][i]==1)
                return false;
            r--;
        }
        r = row+1;
        for(int i=col-1;i>=0;i--){
            if(r==-1 || r==n) break;
            if(mat[r][i]==1)
                return false;
            r++; 
        }
        return true;
    }
    public static void nq(int mat[][],int col,int n,List<List<String>> res){
        if(col==n){
            res.add(print(mat, n));
            return ;
        }
        for(int i=0;i<n;i++){
            mat[i][col]=1;
            if(check(mat,col,i,n)){
                nq(mat,col+1,n,res);
            }
            mat[i][col]=0;
        }
        return ;
    }
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> res = new ArrayList<>();
        int mat[][] = new int [n][n];
        nq(mat,0,n,res);
        return res;
    }
}