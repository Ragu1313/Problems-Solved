class Solution {
    public static int f(int ele ,int arr2[],int x){
        int res = 0;
        int left = 0;
        int right = arr2.length-1;
        while(left<=right){
            int mid = (right+left)/2;
            int temp = arr2[mid] + ele;
            if(temp<=x){
                res = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        if(res+1<arr2.length && Math.abs(arr2[res+1]+ele-x) < Math.abs(arr2[res]+ele-x)){
            return res+1;
        }
        return res;
    }
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        
        int dif = 10000000;
        for(int i:arr1){
            // int temp = i;
            int temp2 = f(i,arr2,x);
            int temp = Math.abs(i+arr2[temp2]-x);
            if(dif>temp){
                dif = temp;
                map.put(dif, new ArrayList<>(Arrays.asList(i, arr2[temp2])));
            }
        }
        return map.get(dif);
    }
}