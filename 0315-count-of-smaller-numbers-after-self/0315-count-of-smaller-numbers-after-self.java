class Fenwick{
    private int arr[];
    private int size;
    public Fenwick(int size){
        arr = new int[size+1];
        this.size = size+1;
    }

    public int count(int val){
        val++;
        int cnt = 0;
        while(val>0){
            cnt+=arr[val];
            val -= val & -val;
        }
        return cnt;
    }

    public void update(int val){
        val++;
        while(val<size){
            arr[val]+=1;
            val += val & -val;
        }
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int offset = 10000;
        Fenwick fen = new Fenwick(20000);
        List<Integer> li = new LinkedList<>();
        for(int i=nums.length-1;i>=0;i--){
            li.addFirst(fen.count(nums[i]-1+offset));
            fen.update(nums[i]+offset);
        }
        return li;
    }
}