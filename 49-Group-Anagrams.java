class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char [] s1 = strs[i].toCharArray();
            Arrays.sort(s1);
            String dup = String.valueOf(s1);
            if(!map.containsKey(dup)){
                map.put(dup,new ArrayList<>());
            }
            map.get(dup).add(strs[i]);
        }
        // System.out.println(map.values());
        return new ArrayList<>(map.values());
    }
}