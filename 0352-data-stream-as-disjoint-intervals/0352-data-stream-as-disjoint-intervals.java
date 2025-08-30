class SummaryRanges {
    ArrayList<Integer> arr ;
    public SummaryRanges() {
        arr = new ArrayList<>();
    }
    
    public void addNum(int value) {
        int inx = binarySearch(value);
        if(inx!=-1)
        arr.add(inx,value);
    }

    public int binarySearch(int value){
        int left = 0;
        int right = arr.size()-1;
        int res = arr.size();
        while(left<=right){
            int mid = (left+right)/2;
            if(arr.get(mid)==value) return -1;
            else if(arr.get(mid)>value){
                res = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return res;

    }
    
    public int[][] getIntervals() {
        ArrayList<int[]> res = new ArrayList<>();
        if(arr.size()==0)  return new int[0][0];
        int start = arr.get(0);
        int end = arr.get(0);
        for(int i=1;i<arr.size();i++){
            if(end+1==arr.get(i)){
                end = arr.get(i);
            }
            else{
                res.add(new int[]{start,end});
                start = arr.get(i);
                end = arr.get(i);
            }
        }
        res.add(new int[]{start,end});
        int n = res.size();
        int result[][] = new int[n][2];
        for(int i=0;i<n;i++){
            result[i][0] = res.get(i)[0];
            result[i][1] = res.get(i)[1];
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */