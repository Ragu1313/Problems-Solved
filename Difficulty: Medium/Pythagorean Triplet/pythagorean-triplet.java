class Solution {
    boolean f(int low,int num,int arr[]){
        // int low = 1;
        int right = 1000;
        // int res = -1;
        // boolean ans = false;
        while(low<=right){
            int mid = (right+low)/2;
            int temp = mid*mid;
            if(temp==num){
                return arr[mid]!=0;
            }
            else if(temp<num){
                low = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return false;
    }
    boolean pythagoreanTriplet(int[] arr) {
        int cnt[] = new int[1001];
        for(int i : arr){
            cnt[i]++;
        }
        for(int i=1;i<1000;i++){
            for(int j=i+1;j<1000;j++){
                if(cnt[i]!=0 && cnt[j]!=0){
                    
                    int temp = i*i + j*j;
                    // System.out.println(i+" "+j+" "+temp);
                    if(f(j+1,temp,cnt)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}