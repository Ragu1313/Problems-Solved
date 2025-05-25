class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        int res = 0;
        // String extra = "";
        // int flag = 0;
        Map<String,Integer> map2= new HashMap<>();
        for(String ch : words){
            char ch1 = ch.charAt(0);
            char ch2 = ch.charAt(1);
            if(ch1==ch2){
                if(map2.get(ch)!=null){
                    map2.remove(ch);
                }
                else{
                    map2.put(ch,1);
                }
            }
            String str = ch2+""+ch1;
            map.putIfAbsent(ch,0);
            if(map.get(ch)>=1){
                map.put(ch,map.get(ch)-1);
                res+=4; 
                // System.out.println(ch);
            }
            else{
                map.put(str,map.getOrDefault(str,0)+1);
            }
        } 
        if(map2.size()>0){
            res+=2;
        }
        return res;
    }
}