class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        String k = x+"";
        for(int i=0;i<words.length;i++){
            if(words[i].contains(k))
                res.add(i);
        }
        return res;
    }
}