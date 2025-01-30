class Solution {
    public void f(int v,List<List<Integer>> adj,List<Set<Integer>> res,int in[]){
        // p.add(v);
        for(int i : adj.get(v)){
            in[i]--;
            Set<Integer> p = res.get(v);
            p.add(v);
            res.get(i).addAll(p);
            if(in[i]==0)
            f(i,adj,res,in);
        }
        // p.remove(v);
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] edge, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Set<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            res.add(new HashSet<>());
        }
        int in[] = new int[n];
        for(int [] e : edge ){
            adj.get(e[1]).add(e[0]);
            in[e[0]]++;
        }
        List<Integer> arr1 = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                arr1.add(i);
            }
        }
        for(int i :arr1){
            f(i,adj,res,in);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i[] : queries ){
            if(res.get(i[0]).contains(i[1])){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}