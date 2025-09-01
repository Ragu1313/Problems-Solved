class Pair{
    int key;
    int fre;
    public Pair(int key,int fre){
        this.key = key;
        this.fre = fre;
    }
}
class Solution {
    public int sumOfModes(int[] arr, int k) {
        Map<Integer,Pair> map = new HashMap<>();
        PriorityQueue<Pair> p = new PriorityQueue<>((a,b)->{
            if(b.fre!=a.fre)  return b.fre - a.fre;
            else return a.key - b.key;
        });
        for(int i=0;i<k;i++){
            map.putIfAbsent(arr[i],new Pair(arr[i],0));
            Pair temp = map.get(arr[i]);
            temp.fre++;
            map.put(arr[i],temp);
        }
        for(int i : map.keySet()){
            p.add(map.get(i));
        }
        int res = 0;
        int left = 0;
        int right = k;
        while(right<arr.length){
            res += p.peek().key;
            // System.out.println(p.peek().key);
            Pair temp = map.get(arr[left]);
            p.remove(temp);
            temp.fre--;
            if(temp.fre!=0){
                map.put(temp.key,new Pair(temp.key,temp.fre));
                p.add(map.get(temp.key));
            }
            map.putIfAbsent(arr[right],new Pair(arr[right],0));
            Pair temp1 = map.get(arr[right]);
            if(temp1.fre!=0){
                p.remove(temp1);
            }
            temp1.fre++;
            map.put(temp1.key,new Pair(temp1.key,temp1.fre));
            p.add(map.get(temp1.key));
            right++;
            left++;
        }
        // System.out.println(p.peek().key);
        res += p.peek().key;
        return res;
        
    }
}