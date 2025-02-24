class Pair{
    int i ;
    List<Integer> arr;
    public Pair(int i){
        arr = new ArrayList<>();
        this.i = i;
    }
    public Pair(int i ,List<Integer> arr){
        this.arr = arr;
        this.i = i;
    }
}
class Pair1{
    int vali;
    // int valj;
    int tot ;
    public Pair1(int vali,int tot){
        this.vali = vali;
        // this.valj = valj;
        this.tot = tot;
    }
}
class Solution {
    int ans = Integer.MIN_VALUE;
    public List<Integer> f(int bob, List<List<Integer>> adj ,int n){
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(bob);
        p.arr.add(bob);
        q.add(p);
        int vis[] = new int[n];
        vis[bob] = 1;
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int tempi = temp.i;
           
            for(int i : adj.get(tempi)){
                if(i==0){
                   List<Integer> res =  temp.arr;
                   res.add(0);
                   return res;
                }
                else if(vis[i]==0){
                    List<Integer> dup = new ArrayList<>(temp.arr);
                    // System.out.println(dup);
                    dup.add(i);
                    vis[i] = 1;
                    q.add(new Pair(i,dup));
                }
            }
        }
        return new ArrayList<Integer>();
    }
    public void f1(List<Integer> arr,List<List<Integer>> adj,int amn[]){
        Queue<Pair1> q = new LinkedList<>();
        int ind = 0;
        q.add(new Pair1(0,0));
        int vis[] = new int[amn.length];
        int arrsize = arr.size();
        // vis[0] = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair1 temp = q.poll();
                int val = temp.tot;
                vis[temp.vali] = 1;
                if(ind==arrsize || temp.vali!=arr.get(ind)){
                    val+=amn[temp.vali];
                    amn[temp.vali] = 0;
                }
                else{
                    val += amn[temp.vali]/2;
                }
                int flag = 0;
                for(int i : adj.get(temp.vali)){
                    if(vis[i]==0){
                        flag =1;
                        q.add(new Pair1(i,val));
                        // System.out.println(i+" "+val);
                    }
                }
                if(flag == 0)   ans = Math.max(ans,val);    
            }
            if(ind<arrsize){
                amn[arr.get(ind)] = 0;
                // System.out.println(ind+" "+amn[ind]);
                ind++;
            }
           
        }
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int des = edges[i][1];
            adj.get(src).add(des);
            adj.get(des).add(src);
        }
        List<Integer> arr = f(bob,adj,n);
        // System.out.println(arr);
        f1(arr,adj,amount);
        return ans;
    }
}