class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = answers.length;
        for(int i=0;i<n;i++){
            map.put(answers[i]+1,map.getOrDefault(answers[i]+1,0)+1);
        }
        int res = 0;
        for(int i : map.keySet()){
            // System.out.println(i+" "+map.get(i));
            int mul = map.get(i)/i;
            if(map.get(i)%i!=0){
                mul++;
            }
            res += (mul*i);
        }
        return res;
    }
}