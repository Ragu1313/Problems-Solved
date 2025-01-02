class Solution {
    int []st;
    public boolean check(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return true;
        }
        return false;
    }
    public void build(int i ,int l ,int h,String[] words){
        if(l==h){
            int len = words[l].length();
            char ch = words[l].charAt(len-1);
            if(check(ch) && check(words[l].charAt(0))){
                st[i] = 1; 
            }
            else{
                st[i] = 0;
            }
            return ;
        }
        int mid = l+(h-l)/2;
        build(i*2+1,l,mid,words);
        build(i*2+2,mid+1,h,words);
        st[i] =  st[i*2+1] + st[i*2+2];
    }
    public int ans(int i ,int low,int high,int l,int h){
        if(low>h || high<l){
            return 0;
        }
        else if(low>=l && high<=h){
            return st[i];
        }
        int mid = low+(high-low)/2;
        return ans(i*2+1,low,mid,l,h) + ans(i*2+2,mid+1,high,l,h);
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        st = new int[words.length*4];
        int n1 = words.length;
        build(0,0,n1-1,words);
        int n  = queries.length;
        int res [] = new int[n];
        for(int i=0;i<n;i++){
            res[i] = ans(0,0,n1-1,queries[i][0],queries[i][1]);
        }
        return res;
    }
}