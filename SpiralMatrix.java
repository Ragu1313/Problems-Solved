class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = matrix.length;
        ArrayList<Integer> a = new ArrayList<>();
        int row = l;
        int column = matrix[0].length;
        int i=0,j=0;
        int prevrow = -1;
        int prevcolumn = -1;
        int flag=0;
        while(row>prevrow && column>prevcolumn){
            for(j=j;j<column;j++){
                flag=1;
                if(j>prevcolumn)
                  a.add(matrix[i][j]);
            }
    
            if(flag==1){
                j = j-1;
                prevrow = prevrow+1;
            }
            
            flag=0;
            for(i=i;i<row;i++){
                flag=1;
                if(i>prevrow )
                    a.add(matrix[i][j]);
            }
            if(flag==1){
                i=i-1;
                
            }
            column--;
            flag=0;
            for(j=j;j>prevcolumn;j--){
                flag=1;
                if(j<column)
                    a.add(matrix[i][j]);
            }
            if(flag==1){
                row--;
            
            }
            j=j+1;
            flag=0;
            for(i=i;i>prevrow;i--){
                flag=1;
                if(i<row)
                    a.add(matrix[i][j]);
            }
            if(flag==1){
                i=i+1;
            
            }
            prevcolumn++;
            flag=0;
            l=l-2;
        }
        return a;
    }
}
