class Solution {
    public void per(int n,int nums[],ArrayList<Integer> p,
    List<List<Integer>> res,boolean flag[] ){
        if(p.size()==n){
            res.add(new ArrayList<>(p));
            return ;
        }
        for(int i=0;i<n;i++){
            if(!flag[i]){
                p.add(nums[i]);
                flag[i]=true;
                per(n,nums,p,res,flag);
                flag[i] = false;
                p.remove(p.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean [] flag = new boolean[n];
        List<List<Integer>> a = new ArrayList<>();
        per(n,nums,new ArrayList<>(),a,flag);
        return a;
    }
}