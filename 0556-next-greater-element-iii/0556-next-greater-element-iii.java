class Solution {
    public int check(int num,int cnt[]){
        // num;
        for(int i=num+1;i<10;i++){
            if(cnt[i]>0)   return i; 
        }
        return -1;
    }
    public int nextGreaterElement(int n) {
        // if(n>=Integer.MAX_VALUE)  return -1;
        String s = String.valueOf(n);
        int cnt[] = new int[10];
        for(int i=s.length()-1;i>=0;i--){
            int num = (int)s.charAt(i)-'0';
            int ind = check(num,cnt) ;
            cnt[num]++;
            if(ind!=-1){
                // System.out.println("hi");
                long res = 0;
                for(int j=0;j<i;j++){
                    res = res*10 +(int) (s.charAt(j)-'0');
                }
                res = res * 10 + ind;
                cnt[ind]--;
                int j = 0;
                while(j<10){
                    while(j<10 && cnt[j]==0) j++;
                    if(j<10 && cnt[j]>0){
                        res = res *10 + j;
                        cnt[j]--;
                    }
                }
                if(res>Integer.MAX_VALUE)  return -1;
                return (int)res;
            }
            
        }
        return -1;
    }
}