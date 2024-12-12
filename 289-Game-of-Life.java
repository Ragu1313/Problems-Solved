class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]>0){
                    
                int cnt = 0;
                if(i-1>=0){
                    if(board[i-1][j]<=0){
                        board[i-1][j]-=1;
                    }
                    else    cnt++;
                }
                if(i-1>=0 && j-1>=0){
                    if(board[i-1][j-1]<=0)
                        board[i-1][j-1]-=1;
                    else    cnt++;
                }
                if(j-1>=0){
                    if(board[i][j-1]<=0)
                        board[i][j-1]-=1;
                    else    cnt++;
                }
                if(j+1 <m && i-1>=0){
                    if(board[i-1][j+1]<=0)
                        board[i-1][j+1]-=1;
                    else    cnt++;
                }
                if(i+1<n ){
                    if(board[i+1][j]<=0)
                        board[i+1][j]-=1;
                    else cnt++;
                }
                if(i+1<n && j+1 <m){
                    if(board[i+1][j+1]<=0)
                        board[i+1][j+1]-=1;
                    else    cnt++;
                }
                if(j+1<m){
                    if(board[i][j+1]<=0)
                        board[i][j+1]-=1;
                    else    cnt++;
                }
                if(i+1 <n && j-1>=0){
                    if(board[i+1][j-1]<=0)
                        board[i+1][j-1]-=1;
                    else    cnt++;
                }
                if(cnt<2 || cnt>3){
                    board[i][j] = 2;
                }
                }
                
            }
        }
        for(int  i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==-3){
                    board[i][j] = 1;
                }
                else if(board[i][j]==2 || board[i][j]<0){
                    board[i][j]=0;
                }
                 
            }
        }
    }
}