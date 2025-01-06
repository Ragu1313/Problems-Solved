class Solution {
    public int[] minOperations(String s) {
        int n=s.length();
        int t1[]= new int[n];
        int t2[]=new int[n];
        int c1=0;
        int c2=0;
        for(int i=0;i<n;i++){
            t1[i]=c1;
            if(s.charAt(i)=='1'){
                c2++;
            }
            c1+=c2;
        }
        c1=0;
        c2=0;
        for(int i=n-1;i>=0;i--){
            t2[i]=c1;
            if(s.charAt(i)=='1'){
                c2++;
            }
            c1+=c2;
        }
        int t3[]=new int[n];
        for(int i=0;i<n;i++){
            t3[i]=t1[i]+t2[i];
        }
        return t3;
    }
}