class Solution {
    boolean check(String s1,String s2){
        int cnt = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                cnt++;
        }
        return cnt==1;
    }
    int bfs(String start,String end,String bank[]){
        if(start.equals(end))   return 0;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<bank.length;i++)  map.put(bank[i],0);
        int cnt = 0;
        if(map.containsKey(start))   map.put(start,1);
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            for(int i=0;i<size;i++){
                String temp = q.poll();
                for(String s : bank){
                    if(check(s,temp) && map.get(s)==0){
                        System.out.println(s);
                        if(s.equals(end))   return cnt;
                        map.put(s,1);
                        q.add(s);
                    }
                }
                // System.out.println(cnt);
            }
        }
        return -1;
    }
    public int minMutation(String start, String end, String[] bank) {
        return bfs(start,end,bank);
    }
}