class Solution {
    int cnt = 0;
    String res = "";
    int l = 0;
    public void f(int prev,int n,char arr[],String p,int k){
        if(n==0){
            cnt++;
            if(k==cnt){
                res = p;
                l = 1;
            }
            return ;
        }
        if(l==1)    return ;
        for(int i=0;i<3;i++){
            if(prev!=i ){
                f(i,n-1,arr,p+arr[i]+"",k);
            }
        }
    }
    public String getHappyString(int n, int k) {
        res ="";
        char arr[] = new char[3];
        arr[0] = 'a';
        arr[1] = 'b';
        arr[2] = 'c';
        f(-1,n,arr,"",k);
        return res;
    }
}