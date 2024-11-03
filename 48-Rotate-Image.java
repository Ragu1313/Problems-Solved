class Solution {
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        // System.out.println(l);
	    int i,j;
	    int temp;
	for(i=0;i<l;i++){
		for(j=i+1;j<l;j++){
//			printf("%d ",matrix[i][j]);
            temp = matrix[i][j];
			matrix[i][j] = matrix[j][i];
			matrix[j][i] = temp;
		}
		
	}

	int m;
		for(i=0;i<l;i++){
			m=l-1;
		  for(j=0;j<l/2;j++){
		  	  temp = matrix[i][j];
		  	  matrix[i][j] = matrix[i][m];
		  	  matrix[i][m] = temp;
		  	  m--;
		  }  
        }
    }
}