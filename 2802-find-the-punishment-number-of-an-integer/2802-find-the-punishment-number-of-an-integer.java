class Pair{
    int num;
    int sqr;
    public Pair(int num,int sqr){
        this.num = num;
        this.sqr = sqr;
    }
}
class Solution {
    List<Pair> arr = new ArrayList<>();
    int flag = 0;
    public void backtrack(String s,int i,int n,int sum,int sq){
        if(flag==1) return ;
        if(i==n){
            if(sum==sq) flag = 1;
            return ;
        }
        if(sum>sq)  return ;
        int dup = 0;
        for(int j = i;j<n;j++){
           dup = dup*10 + Integer.parseInt(s.charAt(j)+"");
           backtrack(s,j+1,n,dup+sum,sq);
        }
    }
    public void f(){
        for(int i=1;i<=1000;i++){
            int sq = i*i;
            String s = String.valueOf(sq);
            flag  = 0;
            backtrack(s,0,s.length(),0,i);
            if(flag==1)    arr.add(new Pair(i,sq));
        }
    }
    public int punishmentNumber(int n) {
        f();
        int res = 0;
        for(Pair p : arr){
            if(p.num>n)   break;
            // System.out.println(p.num +" "+p.sqr);
            res+=p.sqr;
        }
        return res;
    }
}