class Solution {
    public int jump(String n){
        int l = n.length();
        int num = 10;
        for(int i=0;i<l;i++){
            num = num*10;
        }
        return num;
    }
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        while(low<=high){
            String s = String.valueOf(low);
            if(s.length()%2==1){
                // System.out.println(low);
                // low = jump(String.valueOf(low));
                low++;
                continue;
            }
            else{
                
                // int sum = 0;
                int n = s.length()/2;
                int s1 = 0;
                int s2 = 0;
                for(int i=0;i<n;i++){
                    s1+=Integer.parseInt(""+s.charAt(i));
                    s2+=Integer.parseInt(""+s.charAt(i+n));
                }
                if(s1==s2){
                    res++;
                }
                low++;
            }
            
        }
        return res;
    }
}