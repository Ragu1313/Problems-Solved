class Solution {
    public int compress(char[] chars) {
        if(chars.length==1){
            return 1;
        }
        char prev = chars[0];
        int res = 0;
        int l = 0;
        int cnt = 1;
        for(int i=1;i<chars.length;i++){
            if(prev==chars[i]){
                cnt++;
                continue;
            }
            else{
                if(cnt>1){
                    // res+=2;
                    res++;
                    chars[l++] = prev;
                    // if(cnt>0){
                        String s = "";
                        while(cnt>0){
                            s = String.valueOf(cnt%10)+s;
                            cnt/=10; 
                        }
                        for(char cc:s.toCharArray()){
                            chars[l++] = cc;
                        }
                        res = res+s.length();
                    // }
                    // chars[l] = 
                }
                else{
                    res++;
                    chars[l++] = prev;
                }
                prev = chars[i];
                cnt = 1;
            }
        }
        // chars[l++] = prev;
        if(cnt>1){
                    // res+=2;
                    res++;
                    chars[l++] = prev;
                    // if(cnt>0){
                        String s = "";
                        while(cnt>0){
                            s = String.valueOf(cnt%10)+s;
                            cnt/=10; 
                        }
                        for(char cc:s.toCharArray()){
                            chars[l++] = cc;
                        }
                        res = res+s.length();
                    // }
                    // chars[l] = 
        }
        else{
            res++;
            chars[l++] = prev;
        }
        return res;
    }
}