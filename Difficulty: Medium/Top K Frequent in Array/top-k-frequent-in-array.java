class Pair{
    int val;
    int cnt;
    public Pair(int val,int cnt){
        this.val = val;
        this.cnt = cnt;
    }
}
class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        int cnt[] = new int[100001];
        for(int i : arr){
            cnt[i]++;
        }
        PriorityQueue<Pair> p= new PriorityQueue<>((a,b)->{
            if(a.cnt!=b.cnt)  return b.cnt - a.cnt;
            return b.val - a.val;
        });
        for(int i=0;i<100001;i++){
            if(cnt[i]>0)
            p.add(new Pair(i,cnt[i]));
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(k-->0){
            res.add(p.poll().val);
        }
        return res;
    }
}
