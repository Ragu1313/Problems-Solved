class Solution {
    public void per(int n,int arr[],List<Integer> p,List<List<Integer>> res,boolean flag[]){
        if(p.size()==n){
            res.add(new ArrayList<>(p));
            return ;
        }
        for(int j=0;j<=n-1;j++){
            if(!flag[j]){
                flag[j] = true;
                p.add(arr[j]);
                per(n,arr,p,res,flag);
                p.remove(p.size()-1);
                flag[j] = false;
            }
            // per(n,arr,p,res,flag);
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean [] flag = new boolean[n];
        List<List<Integer>> a = new ArrayList<>();
        // for(int i=0;i<n;i++)
            per(n,nums,new ArrayList<>(),a,flag);
        return a;
    }
}