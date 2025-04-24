class Pair{
    char ch;
    int val;
    public Pair(char ch,int val){
        this.ch = ch;
        this.val = val;
    }
}
class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> p = new PriorityQueue<>((a,b)->Integer.compare(b.val,a.val));
        int cnt[] = new int[26];
        for(char ch : s.toCharArray()){
            cnt[ch-'a']++;
        } 
        for(int i=0;i<26;i++){
            if(cnt[i]>0){
                p.add(new Pair((char)(i+'a'),cnt[i]));
            }
        }
        Pair temp2 = null;
        while(!p.isEmpty()){
            Pair temp = p.poll();
            sb.append(temp.ch);
            if(temp2!=null && temp2.val>0) {
                p.add(temp2);
            }
            if(p.isEmpty()){
                break;
            }
            temp.val = temp.val-1;
            temp2 = p.poll();
            temp2.val = temp2.val-1;
            sb.append(temp2.ch);
            if(temp.val>0) 
            p.add(temp);
        }
        return sb.length()==n?sb.toString():"";
    }
}