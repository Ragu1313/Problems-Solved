class Solution {

    public void helper(int ind,List<List<Integer>> adj,int vis[],int []cnt,List<Integer> li,int nums[]){
        // if(vis[i]==0){
        if(ind%2==0){
            cnt[0]++;
        }
        vis[ind] = 1;
        li.add(nums[ind]);
        for(int i : adj.get(ind)){
            if(vis[i]==0){
                helper(i,adj,vis,cnt,li,nums);
            }
        }
        // }
    }

    public long maxAlternatingSum(int[] nums, int[][] swaps) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[] : swaps){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        // int cnt = 1;
        int vis[] = new int[nums.length];
        long res = 0;
        for(int i=0;i<nums.length;i++){
            if(vis[i]==0){
                int count[] = new int[1];
                List<Integer> li = new ArrayList<>();
                helper(i,adj,vis,count,li,nums);
                // cnt++;
                Collections.sort(li);
                int len = li.size()-1;
                while(count[0]>0)
                {
                    res += li.get(len);count[0]--;len--;
                }
                while(len>=0){
                    res -= li.get(len);len--;
                }
            }
        }
        return res;
    }
}