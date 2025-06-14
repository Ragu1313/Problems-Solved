class Solution {
    public int minMaxDifference(int num) {
        StringBuilder s1 = new StringBuilder(String.valueOf(num));
        StringBuilder s2 = new StringBuilder(s1.toString());
        int n = s1.length();
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!='9'){
                char ch = s1.charAt(i);
                for(int j=i;j<n;j++){
                    if(s1.charAt(j)==ch)
                    s1.setCharAt(j,'9');
                }
                break;
            }
        }
        int num1 = Integer.parseInt(s1.toString());
        for(int i=0;i<n;i++){
            if(s2.charAt(i)!='0'){
                char ch = s2.charAt(i);
                for(int j=i;j<n;j++){
                    if(s2.charAt(j)==ch)
                    s2.setCharAt(j,'0');
                }
                break;
            }
        }
        int num2 = Integer.parseInt(s2.toString());
        if(num1>num2)       return num1-num2;
        return num2 - num1;
    }
}