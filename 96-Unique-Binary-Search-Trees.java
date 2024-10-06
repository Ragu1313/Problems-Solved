class Solution {
    public int numTrees(int n) {
        if(n==1)    return 1;
        if(n==2)    return 2;
        int arr[] = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3;i<=n;i++){
            int sum = 0;
            for(int j=0;j<i;j++){
                int left = arr[j];
                int right = arr[i-j-1];
                sum = sum+(left*right);
            }
            arr[i] = sum;
        }
        return arr[n];
    }
}