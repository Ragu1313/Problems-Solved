class Solution {
    public int[] ccc(String s1){
        int arr[] = new int [26];
        for(char ch : s1.toCharArray()){
            arr[ch-'a']++;
        }
        return arr;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Set<String> words2 = new HashSet<>();
        // for(String i : words2){
        //     words2.add(i);
        // }
        int cnt[] = new int[26];
        for(String s : words2){
            int arr[] = ccc(s);
            for(int i=0;i<26;i++){
                cnt[i] = Math.max(cnt[i],arr[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for(String s : words1){
            int arr[] = ccc(s);
            int flag = 0;
            for(int i=0;i<26;i++){
                if(arr[i]>=cnt[i]){
                    continue;
                }
                flag = 1;
            }
            if(flag==0){
                res.add(s);
            }
        }
        return res;
    }
}