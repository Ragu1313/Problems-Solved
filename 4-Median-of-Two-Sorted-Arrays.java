class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int p1 = 0;
        int p2 = 0;
        int res1 = 0;
        int res2 = 0;
        int mid = (arr1.length+arr2.length)/2+1;
        // System.out.println(mid);
        if(mid==1){
            if(arr1.length==1)
                return (float) arr1[0];
            else
                return (float) arr2[0];
        }
        if(arr2.length==0){
            mid = arr1.length/2;
            if(arr1.length%2==0){
                
                return (float)(arr1[mid-1]+arr1[mid])/2;
            }
            else
                return (float)arr1[mid];
        }
        if(arr1.length==0){
            mid = arr2.length/2;
            if(arr2.length%2==0){
                
                return (float)(arr2[mid-1]+arr2[mid])/2;
            }
            else
                return (float)arr2[mid];
        }
        while(mid-->0){
            if(p1 < arr1.length && arr1[p1]<=arr2[p2] ){
                res1 = res2;
                res2 = arr1[p1];
                p1++;
            }
            else if(p2 < arr2.length){
                res1 = res2;
                res2 = arr2[p2];
                p2++;
            }
            if(p1>=arr1.length || p2>=arr2.length)
                break;
        }
        if(mid!=0 ){
            if( p1<arr1.length){
                while(mid-->0){
                    res1 = res2;
                    res2 = arr1[p1];
                    p1++;
                }
            }
            else{
                while(mid-->0){
                    res1 = res2;
                    res2 = arr2[p2];
                    p2++;
                }
            }
        }
        if((arr1.length+arr2.length)%2==0)
        return (float)(res1+res2)/2;
        return (float)res2;
    }
}