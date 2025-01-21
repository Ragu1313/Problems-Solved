class Solution {
    // public boolean c(int arr[][],int i,int j,int n,int m){
    //     int flag = 0;
    //     for(int k=0;k<n;k++){
    //         if(arr[k][j]==0){
    //             flag = 1;
    //             break;
    //         }
    //     }
    //     if(flag==0) return true;
    //     flag = 0;
    //     for(int k=0;k<m;k++){
    //         if(arr[i][k]==0){
    //             flag = 1;
    //             break;
    //         }
    //     }
    //     if(flag==0) return true;
    //     return false;
    // }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        // int vis[][] = new int[n][m];
        int r[] = new int[n];
        int c[] = new int[m];
        Map<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        int n1 = arr.length;
        for(int i=0;i<n1;i++){
            int temp[] = map.get(arr[i]);
             
            r[temp[0]]++;
            c[temp[1]]++;
            if(r[temp[0]]==m || c[temp[1]]==n){
                return i;
            }
        }
        return -1;
    }
}