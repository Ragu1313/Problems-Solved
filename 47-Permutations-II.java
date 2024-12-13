class Solution {
    Set<List<Integer>> res = new HashSet<>();
    void f(int [] arr,int n,List<Integer> temp){
        if(temp.size()==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
            if(arr[i]!=-12){
                int dup = arr[i];
                temp.add(arr[i]);
                arr[i] = -12;
                f(arr,n,temp);
                temp.remove(temp.size()-1);
                arr[i] = dup;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        // int vis[] = new int[n];
        f(nums,n,new ArrayList<Integer>());
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> i:res){
            ans.add(i);
        }
        return ans;
    }
}