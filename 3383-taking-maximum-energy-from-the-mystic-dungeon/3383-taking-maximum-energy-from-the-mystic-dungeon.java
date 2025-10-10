class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int arr[] = new int[n];
        Arrays.fill(arr,Integer.MIN_VALUE);
        for(int i=n-1;i>=0;i--){
            int temp = 0;
            if(i+k<n){
                temp = arr[i+k];
            }
            arr[i] = energy[i] + temp;
        }
        int maxi = Integer.MIN_VALUE;
        for(int i : arr){
            maxi = Math.max(maxi,i);
        }
        return maxi;
    }
}