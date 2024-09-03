class Solution {
    public int getLucky(String s, int k) {
        int temp = 0;
        for(int i=0;i<s.length();i++){
            int val = (int) (s.charAt(i)-96);
            // System.out.println(val);
            if(val<10)
                temp+=val;
            else{
                // System.out.println(val);
                temp += val%10;
                val = val/10;
                temp += val%10;
            }
        }
        if(k==1)
            return temp;
        int res = 0;
        --k;
        while(k-->0){
            res = 0;
            while(temp>0){
                res+=temp%10;
                temp = temp/10;
            }
            temp = res;
            if(temp<10){
                res = temp;
                break;
            }
        }
        return res;
    }
}