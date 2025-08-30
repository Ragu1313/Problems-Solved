class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        // if(n==1)  return -1;
        int arr[] = new int[n];
        int zero = 0;
        for(int i=0;i<n;i++){
            
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    arr[j]++;
                }
            }
        }
        for(int i=0;i<n;i++){
            boolean flag = true;
            if(arr[i]==n){
                for(int j=0;j<n;j++){
                    if(j==i)  continue;
                    if(mat[i][j]==1)  flag = false;
                }
            }
            else{
                flag = false;
            }
            if(flag)  return i;
        }
        return -1;
    }
}