class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<Integer>[] arr =(List<Integer>[]) new List[501];
        
        for(int i=0;i<=500;i++){
            arr[i] = new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr[groupSizes[i]].add(i);
        }
        int cnt = 0;
        for(int i=0;i<=500;i++){
            if(arr[i].size()>0) {
                res.add(new ArrayList<>());
                int temp = 0;
                cnt++;
                for(int k=0;k<arr[i].size();k++){
                    int j = arr[i].get(k);
                    temp++;
                    res.get(cnt-1).add(j);
                    if(temp==i && k!=arr[i].size()-1){
                        temp = 0;
                        cnt++;
                        // System.out.println(cnt+" "+"hi");
                        res.add(new ArrayList<>());
                    }
                }
            }
        }
        return res;
    }
}