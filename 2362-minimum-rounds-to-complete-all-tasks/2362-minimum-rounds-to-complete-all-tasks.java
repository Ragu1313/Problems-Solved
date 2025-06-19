class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        int res = 0;
        for(int i : map.keySet()){
            if(map.get(i)==1)   return -1;
            res+=(map.get(i)/3);
            if(map.get(i)%3!=0) res++;
        }
        return res;
    }
}