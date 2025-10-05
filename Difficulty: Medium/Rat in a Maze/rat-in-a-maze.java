class Solution {
    ArrayList<String> res ;
    public void f(int i,int j,int [][]mat,StringBuilder sb){
        int n = mat.length;
        if(i==n-1 && j==n-1 )  {
            res.add(sb.toString());
            return ;
        }
        
        if(i<0 || j<0 ||i>=n || j>=n || mat[i][j]!=1 ){
            return ;
        }
        int temp = mat[i][j];
        int len = sb.length();
        if(temp==1){
            mat[i][j] = 2;
            sb.append('D');
            f(i+1,j,mat,sb);
            sb.setLength(len);
            sb.append('R');
            f(i,j+1,mat,sb);
            sb.setLength(len);
            sb.append('L');
            f(i,j-1,mat,sb);
            sb.setLength(len);
            sb.append('U');
            f(i-1,j,mat,sb);
            sb.setLength(len);
            mat[i][j] = 1;
        }
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        res = new ArrayList<>();
        int n = maze.length;
        f(0,0,maze,new StringBuilder());
        Collections.sort(res);
        return res;
    }
}