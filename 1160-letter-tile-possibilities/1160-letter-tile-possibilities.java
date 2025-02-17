class Solution {
    Set<String> res = new HashSet<>();
    void f(String p,int[] vis,int size,int n,String s){
        if(n==size)  {
            if(p.length()>0)  res.add(p);
            return ;
        }
        // if(size)
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                vis[i] = 1;
                f(p+String.valueOf(s.charAt(i)),vis,size+1,n,s);
                f(p,vis,size+1,n,s);
                vis[i] = 0;
                
            }
        }
    }
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        int vis[] = new int[n];
        f("",vis,0,n,tiles);
        return res.size();
    }
}