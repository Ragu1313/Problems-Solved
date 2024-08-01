class Solution {
    public int countSeniors(String[] details) {
       //11 12
       int res=0;
       for(int i=0;i<details.length;i++){
            String s = details[i];
            if(Integer.parseInt(s.substring(11,13))>60)
                res++;
       }
       return res;
    }
}