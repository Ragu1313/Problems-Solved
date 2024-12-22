class NumArray {

    int arr[] ;
    int st[] ;
    public NumArray(int[] nums) {
        arr = nums;
        st = new int[4*nums.length];
        build(0,0,nums.length-1);
    }

    public void build(int i,int l,int h){
        if(l==h){
            st[i] = arr[l];
            return ;
        }
        int mid = l+(h-l)/2;
        build(2*i+1,l,mid);
        build(2*i+2,mid+1,h);
        st[i] = st[i*2+1]+st[i*2+2];
    }
    
    public void update(int index, int val) {
        updateHelper(0, 0, arr.length - 1, index, val);
    }

    public void updateHelper(int i, int l, int h, int index, int val) {
        if (l == h && l==index) {
            st[i] = val;
            return;
        }
        int mid = l + (h - l) / 2;
        if (index <= mid) {
            updateHelper(2 * i + 1, l, mid, index, val);
        } else {
            updateHelper(2 * i + 2, mid + 1, h, index, val);
        }
        st[i] = st[2 * i + 1] + st[2 * i + 2];
    }
    
    public int sumRange(int left, int right) {
        return f(left,right,0,0,arr.length-1);
    }

    public int f(int l,int h,int i,int start,int end){
        if(h<start || end<l)    return 0;
        if(l<=start && h>=end)  return st[i];
        int mid = start+(end-start)/2;
        return f(l,h,i*2+1,start,mid) + f(l,h,i*2+2,mid+1,end);
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */