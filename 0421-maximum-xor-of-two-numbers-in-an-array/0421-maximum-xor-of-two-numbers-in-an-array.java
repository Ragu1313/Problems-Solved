class Trie{
    Trie arr[] = new Trie[2];
    public Trie(){
        arr[0]=arr[1] = null;
    }
    public boolean contain(int val){
        return arr[val]!=null;
    }
    public void put(Trie temp,int val){
        arr[val] = temp;
    }
    public Trie get(int val){
        return arr[val];
    }
}
class Solution {
    Trie head = new Trie();
    public int xor(String s){
        Trie node = head;
        int res = 0;
        for(int i=0;i<31;i++){
            int val = s.charAt(i)-'0';
            if(node.contain(1-val)){
                res+=(1<<(30-i));
                node = node.get(1-val);
            }
            else{
                node = node.get(val);
            }
        }
        return res;
    }
    public int insert(int num){
        Trie node = head;
        String s = String.format("%31s",Integer.toString(num,2)).replace(' ','0');
        // System.out.println(s);
        int res = xor(s);
        for(int i=0;i<31;i++){
            int val = s.charAt(i)-'0';
            if(!node.contain(val)){
                node.put(new Trie(),val);   
            }
            node = node.get(val);
        }
        return res;
    }
    public void insert1(int num){
        Trie node = head;
        String s = String.format("%31s",Integer.toString(num,2)).replace(' ','0');
        for(int i=0;i<31;i++){
            int val = s.charAt(i)-'0';
            if(!node.contain(val)){
                node.put(new Trie(),val);   
            }
            node = node.get(val);
        }

    }
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int res = 0;
        insert1(nums[0]);
        for(int i=1;i<n;i++){
            res = Math.max(res,insert(nums[i]));
        }
        return res;
    }
}