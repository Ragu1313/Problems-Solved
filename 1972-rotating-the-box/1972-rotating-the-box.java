class Solution {
    // public void f(int i,int j,char res[][],int cnt ,)
    public char[][] rotateTheBox(char[][] boxGrid) {
        char res[][] = new char[boxGrid[0].length][boxGrid.length];
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[j][i] = boxGrid[i][j];
            }
        }
        int left =0;
        int right = n-1;
        while(left<right){
            for(int i=0;i<m;i++){
                char temp = res[i][left];
                res[i][left] = res[i][right];
                res[i][right] = temp;
            }
            right--;
            left++;
        }
        for(int i=0;i<n;i++){
            // int cnt = 0;
            int top = -1;
            int cnt = 0;
            for(int j=0;j<m;j++){
                if(res[j][i]=='#')  cnt++;
                else if(res[j][i]=='*')  {
                    int row = j-1;
                    // System.out.println(row);
                    while(cnt-->0 && row>top ){
                        res[row][i] = '#';
                        row--;
                    }
                    // System.out.println(row);
                    while(row>top){
                        res[row][i] = '.';
                        row--;
                    }
                    top = j;
                    cnt =0;
                }
            }
            int row = m-1;
            while(cnt-->0){
                res[row][i] = '#';
                row--;
            }
            while(row>top){
                res[row][i] = '.';
                row--;
            }
           
        }
        return res;
    }
}