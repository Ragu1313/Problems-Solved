class Solution {
    public void  subset(List<List<Integer>> a,ArrayList<Integer> p,int nums[],int i,int n){
        if(i==n){
            a.add(new ArrayList<>(p));
            return;
        }
        p.add(nums[i]);
        subset(a,p,nums,i+1,n);
        p.remove(p.size()-1);
        subset(a,p,nums,i+1,n);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> a = new ArrayList<>();
        subset(a,new ArrayList<Integer>(),nums,0,nums.length);
        return a;
    }
}