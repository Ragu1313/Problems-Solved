class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<wall.size();i++){
            int start = 0;
            List<Integer> arr = wall.get(i);
            for(int j=0;j<arr.size()-1;j++){
                start+=arr.get(j);
                map.put(start,map.getOrDefault(start,0)+1);
                if(map.get(start)>sum){
                    sum = map.get(start);
                }
            }
            // System.out.println(map.toString());
        } 
       return wall.size()-sum;
    }
}