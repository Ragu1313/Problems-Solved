class Pair{
    char ch;
    int ind;
    public Pair(char ch,int ind){
        this.ch = ch;
        this.ind = ind;
    }
}
class Solution {
    public String clearStars(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.ch!=b.ch){
                return a.ch-b.ch;
            }
            return b.ind-a.ind;
        });
        int n = s.length();
        char ch[] = s.toCharArray();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            if(ch[i]=='*'){
                arr[i] = 1;
                arr[pq.poll().ind] = 1;;
            }
            else{
                pq.add(new Pair(ch[i],i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }
}