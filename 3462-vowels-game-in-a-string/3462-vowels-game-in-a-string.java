class Solution {
    public boolean doesAliceWin(String s) {
        char ch[]  = s.toCharArray();
        String check = "aeiou";
        for(char c : ch){
            if(check.contains(c+"")){
                return true;
            }
        }   
        return false;
    }
}