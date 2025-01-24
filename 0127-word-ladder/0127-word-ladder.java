class Solution {
    public boolean check(String start,String end){
        int cnt=0;
        for(int i=0;i<start.length();i++){
            if(start.charAt(i)!=end.charAt(i)){
                cnt++;
            }
        }
        return cnt==1;
    }
    public int bfs(String start,String end,List<String> word){
        if(start.equals(end))  return 0;
        Queue<String> q = new LinkedList<>();
        q.add(start);
        Map<String,Integer> map = new HashMap<>();
        for(String s:word)
            map.put(s,0);
        int cnt=0;
        // if(map.containsKey(start)){map.put(start,1);}
        // else    {
            
        //     cnt++;
        // }
        map.put(start,1);
        cnt++;
        if(map.get(end)==null)   return 0;
        while(!q.isEmpty()){
            cnt++;
            int size = q.size();
            for(int i=0;i<size;i++){
                String temp = q.poll();
                for(String s:word){
                    if(check(s,temp) && map.get(s)==0){
                        q.add(s);
                        // System.out.println(s);
                        if(s.equals(end))   return cnt;
                        map.put(s,1);
                    }
                }
            }
            // System.out.println(cnt);
        }
        return 0;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        return bfs(beginWord,endWord,wordList);
    }
}