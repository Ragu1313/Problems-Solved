class Solution {
    public int[][] generateMatrix(int n) {
        int [][] a = new int[n][n];
        for(int[] i:a)
        Arrays.fill(i,-1);
        int left = 0;
        int right = n;
        int top = 0;
        int bottom = n;
        int i=left,j=right;
        int c=1;
        if(n==1)
        a[0][0]=1;
        while(n>0){
            if(c-1==n*n)
            break;

            for(j=left;j<right;j++)
                a[i][j]=c++;

            j--;
            top++;

            for(i=top;i<bottom;i++)
                a[i][j]=c++;
            
            right--;
            i--;

            for(j=right-1;j>=left;j--)
                a[i][j] = c++;

            bottom--;
            j++;

            for(i=bottom-1;i>=top;i--)
                a[i][j] = c++;

            left++;
            i++;
            n=n-2;
        }
        return a;
    }
}
