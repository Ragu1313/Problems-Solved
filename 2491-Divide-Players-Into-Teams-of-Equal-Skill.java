class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int i = 0;
        int j = skill.length-1;
        int diff = skill[j] + skill[i];
        long res = skill[i]*skill[j];
        // System.out.println(skill[i]+" "+skill[j]);
        i++;
        j--;
        while(i<j){
            if(diff!=skill[i]+skill[j]){
                return -1;
            }
            // System.out.println(skill[i]+" "+skill[j]);
            // System.out.println(res);
            res = res+(skill[i]*skill[j]);
            i++;j--;
        }
        return res;
    }
}