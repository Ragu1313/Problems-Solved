class Solution {
    int res = 0;
    public void fun(int i,String s,String sum,Set<String> set){
        if(i==s.length())
            return ;
        String temp = sum + String.valueOf(s.charAt(i));
        if(set.add(temp)){
            fun(i+1,s,"",set);
            res = Math.max(res,set.size());
            set.remove(temp);
        }
        fun(i+1,s,temp,set);
    }
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        fun(0,s,"",set);
        return res;
    }
}