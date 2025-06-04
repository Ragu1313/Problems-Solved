class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1)   return word;
        String res = "";
        int n = word.length();
        for(int i=0;i<n;i++){
            String temp = word.substring(i,Math.min(i+n-numFriends+1,n));
            if(res.compareTo(temp)<=0){
                res = temp;
            }
        }
        return res;
    }
}