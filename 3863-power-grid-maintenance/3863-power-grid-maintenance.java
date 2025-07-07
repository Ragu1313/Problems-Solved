class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
         DSU d = new DSU(c+1);
        for(int [] con : connections){
            d.union(con[0],con[1]);
        }
        
        int online[] = new int[c+1];
        int com[] = new int[c+1];
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=1;i<=c;i++){
            int par = d.find(i);
            map.putIfAbsent(par,new PriorityQueue<>());
            map.get(par).add(i);
            com[i] = par;
        }
        
        // for(int i=0;i<)
        List<Integer> res = new ArrayList<>();
        for(int i[] : queries){
            if(i[0]==1){
                if(online[i[1]]==0){
                    res.add(i[1]);
                    continue;
                }
                PriorityQueue<Integer> temp = map.get(com[i[1]]);
                while(temp!=null &&  !temp.isEmpty() && online[temp.peek()]==-1 ){
                    temp.poll();
                }
                if(!temp.isEmpty())
                    res.add(temp.peek());
                else 
                    res.add(-1);
            }
            else{
                online[i[1]] = -1;
            }
        }
        int ans[] = new int[res.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}

class DSU{
    int arr[];
    int par[];

    public DSU(int n){
        // arr = new int[n];
        par = new int[n+1];
        for(int i=0;i<n+1;i++){
            par[i] = i;
        }
    }
    int find(int i){
        if(i==par[i])  return par[i];
        return par[i] = find(par[i]);
    }
    void union(int u,int v){
        // if(online)
        int parv = find(v);
        int paru = find(u);
        if(parv!=paru){
            if(parv<paru){
                par[paru] = parv;
            }
            else  par[parv] = paru;
        }
    }
}
// class Solution {
//     public List<Integer> processQueries(int c, int[][] connections, int[][] queries) {
       
//     }
// }
