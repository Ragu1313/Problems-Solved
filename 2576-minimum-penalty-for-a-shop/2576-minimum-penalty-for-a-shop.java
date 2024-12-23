class Solution {
    public int bestClosingTime(String cus) { 
        int sum = 0;
         int ind = cus.length(); 
        int cnt= 0; 
        int res = 0; 
        for(char ch:cus.toCharArray()){
            if(ch=='Y') cnt++; 
        } 
        sum = cnt;
        ind = 0; 
        for(int i=0;i<cus.length();i++){ 
            char ch = cus.charAt(i); 
            if(ch=='Y'){ 
                cnt--;
            }
            else{
                cnt++;
            }
            if(sum>cnt){
                sum = cnt;
                ind = i+1;
            }
        }
        return ind;
    }

}