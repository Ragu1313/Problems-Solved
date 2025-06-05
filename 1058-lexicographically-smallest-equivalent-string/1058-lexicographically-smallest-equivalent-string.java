class DSU{
    int par[] ;
    public DSU(){
        par = new int[26];
        for(int i=0;i<26;i++){
            par[i] = i;
        }
    }
    public int getParent(int i){
        if(par[i]==i)   return i;
        return par[i] = Math.min(par[i],getParent(par[i]));
    }

    public void join(int i,int j){
        int par1 = getParent(i);
        int par2 = getParent(j);
        if(par[par1]<par[par2]){
            par[par2] = par[par1];
        }
        else{
            par[par1] = par[par2];
        }
    }
}
class Solution {
    // public void join(int )
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DSU d = new DSU();
        int n = s1.length();
        for(int i=0;i<n;i++){
            int ch1 = s1.charAt(i)-'a';
            int ch2 = s2.charAt(i)-'a';
            d.join(ch1,ch2);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            char ch = (char)(d.getParent(baseStr.charAt(i)-'a')+'a');
            sb.append(ch);
        }
        return sb.toString();
    }
}