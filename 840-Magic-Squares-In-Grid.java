class Solution {
    int sum=0;
    public boolean check(int grid[][] ,int row,int col){
        if(row-1>=0 && col-1>=0 && row+1<grid.length && col+1<grid[0].length){
            // System.out.println(grid[row][col]);
          if(grid[row-1][col-1]!=5 && grid[row+1][col+1]!=5){
            // System.out.println(grid[row][col]);
            Set<Integer> a = new HashSet<>(); 
            int s = 0;
            for(int i=row-1;i<=row+1;i++){
                s=0;
                for(int j=col-1;j<=col+1;j++){
                    // System.out.print(grid[i][j]+" ");
                    s+=grid[i][j];
                    if( a.contains(grid[i][j]) || grid[i][j]<=0 ||  grid[i][j] >=10 )
                        return false;
                    else
                        a.add(grid[i][j]);
                }
                // System.out.println();
                if(s!=15)
                    return false;
            }
            // System.out.println(a.toString());
            a = new HashSet<>();
            // System.out.println(a.toString());
            for(int i=col-1;i<=col+1;i++){
                s=0;
                for(int j=row-1;j<=row+1;j++){
                    // System.out.print(grid[i][j]+" ");
                    s+=grid[j][i];
                    if(a.contains(grid[j][i]) || grid[j][i]<=0 || grid[j][i] >=10 )
                        return false;
                    else
                        a.add(grid[j][i]);
                }
                // System.out.println();
                if(s!=15)
                    return false;
            }
            return true;
          }  
        }
        return false;
    }
    public void num(int grid[][]){

        for(int i=1;i<grid.length-1;i++){
            for(int j=0;j<grid[0].length-1;j++){
                // if(i==1 && j==1)
                    // System.out.println(grid[i][j]);
                if(grid[i][j]==5){
                    if(check(grid,i,j)){
                        sum++;
                    }
                }
            }
        }
    }
    public int numMagicSquaresInside(int[][] grid) {
        num(grid);
        return sum;
    }
}