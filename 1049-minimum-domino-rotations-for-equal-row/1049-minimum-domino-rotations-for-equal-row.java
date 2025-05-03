class Solution {
    public int minDominoRotations(int[] tops, int[] bottom) {
        int arr1[] = new int[7];
        int arr2[] = new int[7];
        int same[] = new int[7];
        int n = tops.length;
        // int same = 0;
        for (int i =0;i<n;i++){
            if(tops[i]==bottom[i]){
                same[tops[i]]++;
            }
            else{
                arr1[tops[i]]++;
                arr1[bottom[i]]++;
                arr2[bottom[i]]++;
            }
        }
        for(int i=1;i<7;i++){
            if(arr1[i]==n-same[i]){
                System.out.println(i +" "+ arr2[i]);
                return Math.min(arr2[i],n-arr2[i]-same[i]);
            }
        }
        return -1;
    }
}