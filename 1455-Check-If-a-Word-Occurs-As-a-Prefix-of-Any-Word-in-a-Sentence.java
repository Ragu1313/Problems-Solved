class Solution {
    public int isPrefixOfWord(String sen, String search) {
        String str[] = sen.split(" ");
        for(int i=0;i<str.length;i++){
            int j=0;
            String arr = str[i];
            while(j<search.length()&& j<arr.length() && arr.charAt(j)==search.charAt(j)){
                j++;
            }
            if(j==search.length()){
                return i+1;
            }
        }
        return -1;
    }
}