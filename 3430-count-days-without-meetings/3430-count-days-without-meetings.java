class Solution {
    public int countDays(int days, int[][] meetings) {
        Map<Long,Integer> map = new TreeMap<>();
        long prev = 1;
        map.put((long)(days+1),0);
        for(int i[] : meetings){
            long start = i[0];
            long end = i[1]+1;
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end,map.getOrDefault(end,0)-1);
        }
        long prefix = 0;
        int res = 0;
        for (long i : map.keySet()){
            if(prev==-1)    prev = i;
            // System.out.println(i + " " + prefix+" "+prev);
            if(prefix==0 && i-prev>0){
                res += (int)(i-prev);
            }
            prefix += map.get(i);
            prev = i;
            
        }

        return res;
    }
}