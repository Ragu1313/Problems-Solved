class Solution {
    ArrayList<ArrayList<Integer>> res ;
    public void f(int ind,int target,int k,boolean vis[],ArrayList<Integer> arr){
        
        if(target==0 && k==0){
            res.add(new ArrayList<>(arr));
            return ;
        }
        
        // if()
        
        if(target<0 || k<0)  return ;
        
        for(int i=ind+1;i<10;i++){
            if(!vis[i] && target-i>=0){
                vis[i] = true;
                arr.add(i);
                f(i,target-i,k-1,vis,arr);
                arr.remove(arr.size()-1);
                vis[i] = false;
            }
        }
    }
    
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        res = new ArrayList<>();
        f(0,n,k,new boolean[10],new ArrayList<>());
        // ArrayList<ArrayList<Integer>> 
        // for(ArrayList<Integer> i : set){
        //     res.add(i);
        // }
        return res;
    }
}