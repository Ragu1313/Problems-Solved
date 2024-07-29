// import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] s) {
        Arrays.sort(s);
        List<List<Integer>> a = new ArrayList<>();
        int powerset = (int)Math.pow(2,s.length);
        for(int i=0;i<powerset;i++){
            List<Integer> s1 = new ArrayList<>();
            for(int j = 0;j<s.length;j++){
                if((i &(1<<j))>0){
                    s1.add(s[j]);
                }
            }
            if(!a.contains(s1))
                a.add(s1);
        }
        return a;
    }
}