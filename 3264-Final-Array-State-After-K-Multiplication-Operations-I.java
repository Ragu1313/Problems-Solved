class Solution {
    public int[] getFinalState(int[] arr, int k, int m) {
        
        while(k-- >0){
            int index=0;
            int value=Integer.MAX_VALUE;
            for(int i=0;i<arr.length;i++){
                if(value>arr[i]){
                    value = arr[i];
                    index = i;
                }
            }
            arr[index] = value*m;
        }
        return arr;

    }
}