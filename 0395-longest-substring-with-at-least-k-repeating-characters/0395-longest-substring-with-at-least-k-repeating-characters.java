class Solution {
    
    public boolean check(int cnt[],int k){
        for(int i : cnt){
            if(i!=0 && i<k)  return false;
        }
        return true;
    }

    public int check1(int inx,int cnt[],char ch[],int k){
        int len = inx;
        int temp[] = new int[26];
        while(inx>=0 && cnt[ch[inx]-'a']>=k){
            temp[ch[inx]-'a']++;
            inx--;
        }
        for(int i : temp){
            if(i!=0 && i<k)  return 0;
        }
        return len - inx;
    }

    public int longestSubstring(String s, int k) {
        int fre[] = new int[26];
        int tot[] = new int[26];
        char ch[] = s.toCharArray();
        for(char c : ch){
            tot[c-'a']++;
        }
        int left = 0;
        int right = 0;
        int res = 0;
        while(right<ch.length){
            if(tot[ch[right]-'a']<k){
                while(left<right){
                    fre[ch[left]-'a']--;
                    tot[ch[left]-'a']--;
                    left++;
                }
                left = right+1;
            }
            else{
                fre[ch[right]-'a']++;
                if(check(fre,k)){
                    res = Math.max(res , right - left + 1);
                    // System.out.println()
                }
            }
            res = Math.max(res,check1(right,fre,ch,k));
            right++;
        }
        return res;
    }
}