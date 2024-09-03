class Solution {
    public int findKthPositive(int[] arr, int k) {
        int c = 1;
        // System.out.pritnln(arr[i]+" "+c);
        int i=0;
        while(i<arr.length){
            if(c==arr[i]){
                // System.out.println(arr[i]+" "+c);
                c++;
                i++;
                continue;    
            }   
            else{
                while(c<arr[i]){
                    // System.out.println(arr[i]+" "+c);
                    c++;
                    k--;
                    
                    if(k==0)
                        return c-1;
                }
            }
        }
        // System.out.println(c+k);
        if(k>0)
            return c+k-1;
        
        return 0;
    }
}