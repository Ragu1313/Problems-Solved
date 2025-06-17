class Solution {
    public void f(int i,int tar,int n,int can[],List<Integer> p,List<List<Integer>> res){
        if(i==n && tar==0)  {
            res.add(new ArrayList<>(p));
            return ;
        }
        if(i==n) return;
        f(i+1,tar,n,can,p,res);
        if(tar>=can[i]){
            p.add(can[i]);
            f(i,tar-can[i],n,can,p,res);
            p.remove(p.size()-1);
        } 
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        f(0,target,candidates.length,candidates,arr,res);
        return res; 
    }
}