
class Solution {

    public void f(String src,Map<String,PriorityQueue<String>> adj,List<String> p,int cnt,List<String> res){
        
       
        PriorityQueue<String> pq = adj.get(src);
        while(pq!=null && !pq.isEmpty()){
            f(pq.poll(),adj,p,cnt-1,res);
        }
        // p.remove(p.size()-1);
        p.addFirst(src);
        // return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        String src = "JFK";
        Map<String,PriorityQueue<String>> adj = new HashMap<>();
        int cnt = 0;
        for(List<String> li : tickets){
            adj.putIfAbsent(li.get(0),new PriorityQueue<>());
            adj.get(li.get(0)).add(li.get(1));
            // cnt++;
        }
        List<String> res = new ArrayList<>();
        List<String> p = new ArrayList<>();
        // p.add("JFK");
        f(src,adj,p,cnt,res);
        return p;
    }
}