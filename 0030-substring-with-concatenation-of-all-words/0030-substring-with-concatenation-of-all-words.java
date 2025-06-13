class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> cur;
        for(String i : words){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int n = words[0].length();
        int n1 = s.length();
        // int res = 0;
        List<Integer> res = new ArrayList<>();
        for(int k=0;k<n;k++){
            cur = new HashMap<>();
            int left = k;
            int right = k;
            int cnt = 0;
            while(right+n<=n1){
                String dup = s.substring(right,right+n);
                cur.put(dup,cur.getOrDefault(dup,0)+1);
                cnt++;
                if(map.get(dup)==null)  {
                    cur = new HashMap<>();
                    cnt = 0;
                    left = right+n;
                    right+=n;
                    continue;
                }
                while(cur.get(dup)>map.get(dup)){
                    String t = s.substring(left,left+n);
                    // if(cur.get(t)==1)
                    // cur.remove(t);
                    // else
                    cur.put(t,cur.get(t)-1);
                    cnt--;
                    left+=n;
                }
                if(cnt==words.length){
                   res.add(left);
                }
                right+=n;
            }
            
        }
        return res;
    }
}