class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        } 
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++){
            int temp = map.get(s.charAt(i));
            if(end<temp){
                end = temp;
            }
            else if(end==i){
                // System.out.println(i);
                list.add(end-start+1);
                start = i+1;
                end = i+1;
            }
        }
        return list;
    }
}