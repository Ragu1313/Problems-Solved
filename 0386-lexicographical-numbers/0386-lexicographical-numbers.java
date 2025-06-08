// class Trie{
//     Trie arr[];
//     public Trie(){
//         arr = new Trie[10];
//     }
//     public void put(Trie newTrie,Trie node){
//         node = newTrie;
//     }
    
// }
class Solution {

    // Trie head = new Trie();
    public void f(int n,int len,int prev,List<Integer> arr){
        // int cnt = 0;
        if(len<=-1 || prev>n)    return ;
        // Trie temp = head;
        // Queue<Trie> q = new LinkedList<>();
        // q.add(head);
        int temp = prev;
        for(int i=0;i<=9;i++){
            temp = prev*10 + i;
            if(temp<=n && temp!=0)  arr.add(temp);
            f(n,len-1,temp,arr);
        }
    }


    public List<Integer> lexicalOrder(int n) {
        int len = (int)(Math.log(13)+1);
        List<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=9;i++){
            if(i<=n){
                arr.add(i);
                f(n,len,i,arr);
            }
        }
        return arr;
    }
}