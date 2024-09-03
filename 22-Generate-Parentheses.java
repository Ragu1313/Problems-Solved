class Solution {
    List<String> res = new ArrayList<>();
    public void generate(String s,int oc , int cc,int n){
        if(oc==n && cc==n){
            res.add(s);
            return ;
        }
        if(oc+1<=n)
            generate(s+\(\,oc+1,cc,n);
        if(cc+1<=n && oc>cc)
            generate(s+\)\,oc,cc+1,n);
    }
    public List<String> generateParenthesis(int n) {
        generate(\\,0,0,n);
        return res;
    }
}