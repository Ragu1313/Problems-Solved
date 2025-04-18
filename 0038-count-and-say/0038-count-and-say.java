class Solution {
    public StringBuilder build(StringBuilder sb){
        int n = sb.length();
        int i = 0;
        StringBuilder res = new StringBuilder();
        while(i<n){
            char ch = sb.charAt(i);
            int cnt = 1;
            i++;
            while(i<n && ch==sb.charAt(i)){
                cnt++;
                i++;
            }
            res.append(String.valueOf(cnt));
            res.append(ch);
            // System.out.println("hi");
        }
        // System.out.println(res);
        return res;
        
    }
    public String f(StringBuilder sb , int k){
        if(k==0){
            return sb.toString();
        }
        return f(build(sb),k-1);
    }
    public String countAndSay(int n) {
        if(n==0)    return "";
        return f(new StringBuilder("1"),n-1);
    }
}