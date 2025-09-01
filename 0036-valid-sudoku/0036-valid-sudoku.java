class Solution {

    public boolean check(int row,int col,char [][] board,char ch){
        for(int i=0;i<9;i++){
            if(i!=row && board[i][col]==ch)  return false; 
        }

        for(int j=0;j<9;j++){
            if(j!=col && board[row][j]==ch)  return false;
        }
        
        int rowStart = row/3 * 3;
        int colStart = col/3 * 3;
        int rowEnd = rowStart + 3;
        int colEnd = colStart + 3;
        for(int i=rowStart;i<rowEnd;i++){
            for(int j=colStart;j<colEnd;j++){
                if((i!=row && j!=col) &&  board[i][j]==ch)  return  false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( board[i][j]!='.' && !check(i,j,board,board[i][j])){
                    // System.out.println(i+" "+j+" "+board[i][j]);
                    return false;
                }
            }
        }
        return true;
    }
}