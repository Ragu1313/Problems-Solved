class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void combine(int []arr,int target,int index,ArrayList<Integer> p){
        if(target==0){
            res.add(new ArrayList(p));
                 return ;
        }
        if(index>=arr.length)
            return;
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            p.add(arr[i]);
            combine(arr,target-arr[i],i+1,p);
            p.remove(p.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        combine(arr,target,0,new ArrayList<Integer>());
        return res;
    }
}