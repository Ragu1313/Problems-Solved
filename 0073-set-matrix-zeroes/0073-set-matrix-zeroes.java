class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        ArrayList<Integer> a = new ArrayList<>();
        int i;
        for(i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(matrix[i][j]==0){
                    a.add(i);
                    a.add(j);
                }
            }
        }
        int len = a.size();
        i=0;
        while(i<len){
            int r = a.get(i);
            int c = a.get(i+1);
            for(int j=0;j<column;j++){
                matrix[r][j]=0;
            }
            for(int j=0;j<row;j++)
                matrix[j][c]=0;
            i+=2;
        }
    }
}