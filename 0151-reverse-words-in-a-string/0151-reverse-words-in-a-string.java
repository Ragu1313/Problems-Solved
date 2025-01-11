class Solution {
    // public StringBuilder rev(StringBuilder sb){
    //     int i = 0;
    //     int j = sb.length()-1;
    //     while(i<j){
    //         StringBuilder temp = String.valueOf(sb.charAt(i));
    //         sb.charAt(i) = sb.charAt(j);
    //         sb.charAt(j) = temp; 
    //     }
    //     return sb;
    // }
    public String reverseWords(String s) {
        // String res = "";
        int cnt = 0;
        int flag = 0;
        StringBuilder sb = new StringBuilder(); 
        StringBuilder res1 = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch==' ' && flag == 0){
                flag = 0;
                continue;
            }
            else if(ch==' ' && flag==1){
                sb.reverse();
                res1.append(sb);
                res1.append(' ');
                // System.out.println(sb+" ");
                sb = new StringBuilder();
                flag = 0;
            }
            else if(ch!=' '){
                flag = 1;
                // System.out.print(ch+" ");
                sb.append(ch);
            }
        }
        if(flag==1){
                sb.reverse();
                res1.append(sb);
                // res1.append(' ');
                // System.out.println(sb+" ");
                // sb = new StringBuilder();
                // flag = 0;
            }
        return res1.toString().trim();
    }
}