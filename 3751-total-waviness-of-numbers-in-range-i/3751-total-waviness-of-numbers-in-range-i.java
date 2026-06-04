class Solution {
    public int totalWaviness(int num1, int num2) {
        int res = 0;
        for(int i=num1;i<=num2;i++){
            if(i<100)   continue;
            String temp = String.valueOf(i);
            int n = temp.length();
            for(int j=1;j<n-1;j++){
                char cur = temp.charAt(j);
                if( (cur>temp.charAt(j-1) && cur>temp.charAt(j+1)) || (cur<temp.charAt(j-1) && cur<temp.charAt(j+1) ) ){
                    res++;
                }
            }

        }
        return res;
    }
}