class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int rem =0;
        int rev=0 ;
        if(x>-1){
            while(x>0){
                rem = x%10;
                rev = (rev*10) + rem;
                x= x/10;
            }
            if(temp==rev){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
        
    }
}