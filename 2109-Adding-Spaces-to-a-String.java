class Solution {
    public String addSpaces(String s, int[] sp) {
        StringBuilder sb = new StringBuilder();
        // Arrays.sort(sp);
        int i=0;
        while(i<sp.length && sp[i]==0){
            sb.append(" ");
            i++;
        }
        int j = 0;
        for(;i<sp.length;i++){
            int temp = sp[i];
            while(j<temp){
                sb.append(s.charAt(j));
                j++;
            }
            if(j==temp)
                sb.append(" ");
            
        }
        for(;j<s.length();j++){
            sb.append(s.charAt(j));
        }
        return String.valueOf(sb);
    }
}