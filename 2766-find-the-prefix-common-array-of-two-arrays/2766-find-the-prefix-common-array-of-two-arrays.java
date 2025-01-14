class Solution {
    public int f(int arr1[],int arr2[]){
        int n = arr1.length;
        int res = 0 ;
        for(int i=0;i<n;i++){
            if(arr1[i]==1 && arr2[i]==1){
                res++;
            }
        }
        return res;
    }
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            // if(arr1[B[i]-1]==1 || arr2[A[i]-1]==1){
            arr1[A[i]-1] = 1;
            arr2[B[i]-1] = 1;
            int c = f(arr1,arr2);
            res[i] = c;
            // }
            
        }
        return res;
    }
}