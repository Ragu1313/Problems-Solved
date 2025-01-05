class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int arr[] = new int[s.length()+1];
        // Map<Integer,Character> map 
        for(int i=0;i<shifts.length;i++){
            int tt = shifts[i][2];
            int start = shifts[i][0];
            int end = shifts[i][1];
            if(tt==0){
                arr[start]--;
                arr[end+1]++;
            }
            else{
                arr[start]++;
                arr[end+1]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i=0;i<s.length();i++){
            sum+=arr[i];

            int ii = (int)((s.charAt(i)-'a')+sum);
            ii=ii%26;
            if(ii<0){
                ii = 26+ii;
            }
            else if(ii>25){
                ii = ii%26;
            }
            ii=ii%26;
            // System.out.println(ii);
            char ch = (char)(ii+'a');
            
            // char temp = (char)(ch+sum);
            // System.out.println(ch+" "+sum+" ");
            sb.append(ch);
        }
        return sb.toString();
    }
}