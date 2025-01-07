class Solution {
    public List<String> stringMatching(String[] words) {
        // Arrays.sort(words);
        List<String> res = new ArrayList<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            String temp = words[i];
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(words[j].contains(temp)){
                    res.add(temp);
                    break;
                }
            }
        }
        return res;
    }
}