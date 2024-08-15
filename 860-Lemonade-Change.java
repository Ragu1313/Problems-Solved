class Solution {
    public boolean lemonadeChange(int[] bills) {
        int l = bills.length;
        int res = 5;
        int resten = 0;
        if(bills[0]!=5){
            return false;
        }
        for(int i=1;i<bills.length;i++){
            if(bills[i]==5){
                res+=5;
            }
            else if(bills[i]==10){
                if(res>0){
                    res-=5;
                    resten+=10;
                }   
                else
                    return false;
            }
            else if(bills[i]==20){
                if(resten>=10 && res>0){
                    resten-=10;
                    res-=5;
                }
                else if(res>=15){
                    res-=15;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}