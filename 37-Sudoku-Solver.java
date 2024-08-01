class Solution {
    private static boolean sudoku(char[][] mat) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(mat[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(solve(i,j,mat,ch)){
                            mat[i][j] = ch;
                            if(sudoku(mat)){
                                return true;
                            }else{
                            \tmat[i][j]='.';
\t\t\t                }
                        }
                        
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean solve(int row, int col, char[][] mat, char ch) {
        for(int i=0;i<9;i++){
            if(mat[i][col]==ch) return false;
            if(mat[row][i]==ch) return false;
            if(mat[(3*(row/3)+i/3)][(3*(col/3)+i%3)]==ch) return false;
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        sudoku(board);
    }
}