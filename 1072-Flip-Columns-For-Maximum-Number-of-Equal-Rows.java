class Solution {
    public int maxEqualRowsAfterFlips(int[][] mat) {
        // return 2; 
        Map<String,Integer> map = new  HashMap<>();

        for(int [] row : mat){
            int flag = row[0];
            StringBuilder sb = new StringBuilder();
            for(int i : row){
                if(flag==i){
                    sb.append("0");
                }
                else{
                    sb.append("1");
                }
            }
            String s = String.valueOf(sb);
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int maxi = 0;
        for(String s : map.keySet()){
            if(maxi<map.get(s)){
                maxi = map.get(s);
            }
        }
        return maxi;
    }
}