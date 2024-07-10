class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = matrix.length;
        ArrayList<Integer> a = new ArrayList<>();
        int row = l;
        int column = matrix[0].length;
        int i=0,j=0;
        int prevrow = 0;
        int prevcolumn = 0;
        int flag=(matrix.length*matrix[0].length);
        while(l>0){
            System.out.println(a.size());
            if(a.size()==flag)
                break;

            for(j=prevcolumn;j<column;j++){
                a.add(matrix[i][j]);
            }
            j = j-1;
            prevrow = prevrow+1;
            
            if(a.size()==flag)
                break;
            for(i=prevrow;i<row;i++){
                a.add(matrix[i][j]);
            }
            i=i-1;
            column--;
            
            if(a.size()==flag)
                break;
            for(j=column-1;j>=prevcolumn;j--){
                a.add(matrix[i][j]);
            } 
            row--;
            j=j+1;
            
            if(a.size()==flag)
                break;
            for(i=row-1;i>=prevrow;i--){
                a.add(matrix[i][j]);
            }
            i=i+1;
            prevcolumn++;

            l=l-2;
        }
        System.out.println(a.size());
        return a;
    }
}
