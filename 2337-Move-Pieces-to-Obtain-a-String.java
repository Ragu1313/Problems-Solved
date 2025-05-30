class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i=0;
        int j=0;
        while(i<j || j<n){
            while(i<n && start.charAt(i)=='_'){
                i++;
            }
            while(j<n && target.charAt(j)=='_'){
                j++;
            }
            if(i<n && j<n && start.charAt(i)!=target.charAt(j)){
                return false;
            }
            if((i==n &&j<n ) || (j==n && i<n))
                return false;
            if(i<n && start.charAt(i)=='L'){
                if(i<j){
                    return false;
                }
            }
            if(i<n && start.charAt(i)=='R'){
                if(i>j){
                    return false;
                }
            }
            i++;
            j++;
        }
        return true;
    }
}