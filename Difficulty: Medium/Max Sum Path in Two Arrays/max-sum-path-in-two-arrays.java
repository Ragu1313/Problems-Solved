class Solution {
    public int maxPathSum(int[] a, int[] b) {
        int res=0;
        int sum1 = 0;
        int sum2 = 0;
        int inx1 = 0;
        int inx2 = 0;
        int n1 = a.length;
        int n2 = b.length;
        while(inx1<n1 && inx2<n2){
            // sum1 += a[inx1];
            // sum2 += b[inx2];
            if(a[inx1]>b[inx2]){
                sum2 += b[inx2];
                inx2++;
                
            }
            else{
                sum1 += a[inx1];
                if(a[inx1]==b[inx2]){
                    sum2 += b[inx2];
                    inx2++;
                    // System.out.println(inx1+" "+inx2+" "+sum1+" "+sum2);
                    res += sum1>sum2?sum1:sum2;
                    sum1 = 0;
                    sum2 = 0;
                }
                inx1++;
            }
            
            
        }
        
        while(inx1<n1){
            sum1 += a[inx1];
            inx1++;
        }
        while(inx2<n2){
            sum2 += b[inx2];
            inx2++;
        }
        res += sum1>sum2?sum1:sum2;
        return res;
    }
}