class Solution {
    public String compressedString(String word) {
        int c = 0;
        char prev = word.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch==prev && c<8){
                c++;    
            }
            else{
                c++;
                String temp = String.valueOf(c) + String.valueOf(prev);
                sb.append(temp);
                prev = ch;
                c=0;
            }
        }
        String temp = String.valueOf(c+1) + String.valueOf(prev);
        sb.append(temp);
        return String.valueOf(sb);
    }
}