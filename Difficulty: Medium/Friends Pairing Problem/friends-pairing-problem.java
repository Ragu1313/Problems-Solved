class Solution {
    public int f(int n){
        if(n<=2){
            return n;
        }
        return f(n-1)+(n-1)*f(n-2);
    }
    public int countFriendsPairings(int n) {
        return f(n);
    }
}
