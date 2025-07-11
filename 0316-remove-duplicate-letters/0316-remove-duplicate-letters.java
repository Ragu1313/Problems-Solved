class Solution {
    public String removeDuplicateLetters(String s) {
        int cnt[] = new int[26];
        char ch [] = s.toCharArray();
        for(char c : ch){
            cnt[c-'a']++;
        }
        boolean flag[] = new boolean[26];
        Stack<Character> st = new Stack<>();
        for(char c : ch){
            while(!st.isEmpty() && !flag[c-'a'] && st.peek()>c && cnt[st.peek()-'a']>0){
                flag[st.pop()-'a'] = false;
            }
            if(flag[c-'a']==false){
                st.push(c);
                
                flag[c-'a'] = true;
            }
            cnt[c-'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}