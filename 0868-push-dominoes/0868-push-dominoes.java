class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int arr[] = new int[n];
        // 0 -> .
        // 1 ->R
        //-1 ->L
        for(int i=0;i<n;i++){
            if(dominoes.charAt(i)=='L'){
                arr[i] = -1;
            }
            else if(dominoes.charAt(i)=='R'){
                arr[i] = 1;
            }
        }
        int left = 0;
        int right = 0;
        while(right<n){
            if(arr[right]==1){
                int temp = right;
                while(temp<n && arr[temp]!=-1){
                    if(arr[temp]==1){
                        while(right<temp){
                            arr[right++] = 1;
                        }
                        left = right;
                    }
                    temp++;
                }
                if(temp==n){
                    while(right<n){
                        arr[right++] = 1;
                    }
                    left = right;
                }
                else{
                    int mid = (temp-right-1)/2;
                    int dup = right;
                    while(dup<=right+mid){
                        arr[dup++] = 1;
                    }
                    dup = temp - mid;
                    while(dup<temp){
                        arr[dup++] = -1;
                    }
                    left = dup;
                }
                right = temp;
            }
            else if(arr[right]==-1){
                int temp = right;
                while(temp>=left){
                    arr[temp--] = -1;
                }
                left = right+1;
            }
            right++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i==0?'.':i==1?'R':'L');
        }
        return sb.toString();
    }
}