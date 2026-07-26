
class Trie{
    
    Trie arr[];
    int cnt[];
    
    public Trie(){
        arr = new Trie[26];
        cnt = new int[26];
    }
    
    public boolean isUnique(char ch){
        return cnt[ch-'a']==1;
    }
    
    public void put(char ch){
        if(arr[ch-'a']==null)
            arr[ch-'a'] = new Trie();
        cnt[ch-'a']++;
    }
    
    public Trie get(char ch){
        return arr[ch-'a']; 
    }
    
}

class Solution {
    
    Trie head = new Trie();
    
    public void built(String [] arr){
        
        
        for(String s : arr){
            Trie temp = head;
            for(char c : s.toCharArray()){
                temp.put(c);
                // System.out.print(temp.cnt[c-'a']);
                temp = temp.get(c);
            }
            // System.out.println();
        }
        
    }
    
    public ArrayList<String> find(String arr[]){
        ArrayList<String> res = new ArrayList<>();
        for(String s : arr){
            Trie temp = head;
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                // temp.put(c,new Trie());
                sb.append(c);
                if(temp.isUnique(c)){
                    res.add(sb.toString());
                    break;
                }
                temp = temp.get(c);
                // if(temp.)
            }
            // System.out.println(sb.toString());
        }
        
        return res;
    }
    
    public ArrayList<String> findPrefixes(String[] arr) {
        built(arr);
        return find(arr);
    }
}