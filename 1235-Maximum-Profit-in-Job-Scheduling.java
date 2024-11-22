// import java.util.Arrays;

class Solution {


    void quicksort(int l,int r,int arr1[],int arr2[],int arr3[]){
        if(l>r){
            return ;
        }
        int i = l;
        int j = r;
        int mid = l+(r-l)/2;
        while(l<=r){
            while(arr1[l]<arr1[mid])    l++;
            while(arr1[r]>arr1[mid])    r--;
            if(l<=r){
                int temp = arr1[l];
                arr1[l]  = arr1[r];
                arr1[r] = temp;
                temp = arr2[l];
                arr2[l] = arr2[r];
                arr2[r] = temp;
                temp = arr3[l];
                arr3[l] = arr3[r];
                arr3[r] = temp;
                l++;r--;
            }
        }
        quicksort(i,r,arr1,arr2,arr3);
        quicksort(l,j,arr1,arr2,arr3);
    }


    public int jobScheduling(int[] start, int[] end, int[] profit) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        // quicksort(0,start.length-1,start,end,profit);
        int dp[][] = new int[start.length][3];
        for(int i=0;i<start.length;i++){
            dp[i] = new int[] {start[i],end[i],profit[i]};
        }
        Arrays.sort(dp ,(a,b)->a[1]-b[1]);
        map.put(0,0);
        for(int i=0;i<start.length;i++){
            int val = dp[i][2] + map.floorEntry(dp[i][0]).getValue();
            if(val>map.lastEntry().getValue()){
                map.put(dp[i][1],val);
            }
        }
        return map.lastEntry().getValue();
    }
}
