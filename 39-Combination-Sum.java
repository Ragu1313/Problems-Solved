class Solution {
    public void combination(int i,int target,int n,int []arr,ArrayList<Integer> p,
    List<List<Integer>> res){
       if(n==i){
            if(target==0){
                res.add(new ArrayList<>(p));
                return;
            }
            else
                return ;
       }
        if(arr[i]<=target){
            p.add(arr[i]);
            combination(i,target-arr[i],n,arr,p,res);
            p.remove(p.size()-1);
        }
        combination(i+1,target,n,arr,p,res);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combination(0,target,candidates.length,candidates,new ArrayList<Integer>(),res);
        return res;
    }
}