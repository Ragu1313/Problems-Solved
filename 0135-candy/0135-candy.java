class Solution {
    public int candy(int[] ratings) {
        int cnt = 1;
        int n = ratings.length;
        int arr[] = new int[n];
        arr[0] = 1;
        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                arr[i] = arr[i-1]+1;
            }
            else{
                arr[i] = 1;
            }
        }
        int res = 0;
        res+= Math.max(arr[n-1],1);
        for(int i=n-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                cnt++;
                res+=Math.max(arr[i],cnt);
            }
            else{
                cnt = 1;
                res+=Math.max(arr[i],cnt);
            }
        }
        return res;
    }
}