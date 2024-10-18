/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // boolean res = false;
        int l = 1;
        int r = n;
        while(l<=r){
            int mid = l+(r-l)/2;
            // System.out.println(mid);
            boolean res = isBadVersion(mid);
            boolean res1 = true;
            if(mid!=0)
            res1 = isBadVersion(mid-1);
            if(res && !res1){
                return mid;
            }
            else if(res && res1) r=mid-1;
            else if(!res && !res)   l = mid+1;
        }
        return -1;
    }
}