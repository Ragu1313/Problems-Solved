class Solution {
    public int f(int arr[],int tar,int n){
        int low = 0;
        int high = n-1;
        int res = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]<=tar){
                res = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return res;
    }
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 1;
        int high = 2000;
        int res = -1;
        int centre = (n*m)/2+1;
        while(low<high){
            int mid = low + (high-low)/2;
            int cnt = 0;
            for(int i[] : mat){
                cnt += f(i,mid,m)+1;
            }
            if(cnt<centre){
                low = mid +1;
                // res = mid;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
} 