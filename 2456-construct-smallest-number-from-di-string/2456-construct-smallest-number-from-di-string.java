class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> s = new Stack<>();
        int n = pattern.length();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<n;i++){
            if(pattern.charAt(i)=='I' && !s.isEmpty()){
                // s.push(i+1);
                res.append(String.valueOf(i+1));
                while(!s.isEmpty())
                res.append(String.valueOf(s.pop()));
            }
            else if(pattern.charAt(i)=='I'){
                res.append(String.valueOf(i+1));
            }
            else{
                s.push(i+1);
            }
        }
        // s.push(i+1);
        res.append(n+1);
        while(!s.isEmpty())
        res.append(String.valueOf(s.pop()));
        return res.toString();
    }
}