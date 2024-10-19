class Solution {
    public char findKthBit(int n, int k) {
        int c=1;
        StringBuilder sb = new StringBuilder("0");
        while(c<k){
            // System.out.println(sb.toString());
            StringBuilder sb1 = new StringBuilder();
            int size = sb.length();
            for(int i=0;i<size;i++){
                char ch = sb.charAt(i)=='0'?'1':'0';
                sb1.append(ch);
            }
            sb.append('1');
            // sb1 = sb1.reverse();
            sb.append(sb1.reverse());
            c = c+c+1;
            if(c>=k){
                // System.out.println(sb.toString());
                return sb.charAt(k-1);
            }
                
        }
        return '0';
    }
}