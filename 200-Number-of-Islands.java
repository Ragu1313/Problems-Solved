class Solution {
    public void traversal(int i,int j,int n,int m,char [][]mat){
        if(i<0 || j<0 || i>n || j>m || mat[i][j]!='1')
            return ;
        mat[i][j] = '2';
        traversal(i,j+1,n,m,mat);
        traversal(i,j-1,n,m,mat);
        traversal(i+1,j,n,m,mat);
        traversal(i-1,j,n,m,mat);
    }
    public int numIslands(char[][] mat) {
        int res=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]=='1'){
                    traversal(i,j,mat.length-1,mat[0].length-1,mat);
                    res++;
                }
                    
            }
        }
        return res;
    }
}