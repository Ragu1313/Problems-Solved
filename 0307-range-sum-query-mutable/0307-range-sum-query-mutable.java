class NumArray {

    int nums[] ;
    int fen[] ;
    public NumArray(int[] nums) {
        this.nums = nums;
        fen = new int[nums.length+1];
        // fen = Arrays.copyOf(nums,nums.length);
        for(int i=0;i<nums.length;i++){
            add(i,nums[i]);
        }
    }

    public void add(int index,int val){
        index++;
        while(index<=nums.length){
            fen[index]+=val;
            index += index & -index;
        }
    }
    
    public void update(int index, int val) {
        // index;
        int dif = val - nums[index];
        nums[index] = val;
        add(index,dif);
    }

    public int sum(int index){
        int sum = 0;
        index++;
        while(index>0){
            sum+=fen[index];
            index -= index & -index;
        }
        return sum;
    }
    
    public int sumRange(int left, int right) {
        
        return sum(right) - sum(left-1); 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */