class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        // int n = a.length;
        int arr[] = new int[n];
        int n1 = a.length;
        for(int i=0;i<n1;i++){
            int start = a[i];
            int end = b[i];
            if(start<n)
                arr[start] += k[i];
            if(end+1<n)
                arr[end+1] -= k[i];
        }
        int sum = 0;
        int res = 0;

        for(int i=0;i<n;i++){
            sum += arr[i]  ;
            res = Math.max(res,sum);
        }
        return res;
    }
}
