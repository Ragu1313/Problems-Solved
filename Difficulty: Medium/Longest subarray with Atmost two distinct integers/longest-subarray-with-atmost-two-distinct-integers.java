class Solution {
    public int totalElements(int[] arr) {
        int cnt = 0;
        int fre[] = new int[100001];
        int res = 0;
        int left = 0;
        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            if(fre[temp]==0){
                cnt++;
            }
            fre[temp]++;
            while(cnt>2){
                fre[arr[left]]--;
                if(fre[arr[left]]==0){
                    cnt--;
                }
                left++;
            }
            res = Math.max(res,i-left+1);
        }
        return res;
    }
}