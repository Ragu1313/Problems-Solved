
class Solution {

    // public boolean f(String src, Map<String, List<String>> adj, List<String> res, int n) {
    //     if (res.size() == n + 1) return true;
    //     List<String> destList = adj.getOrDefault(src, new ArrayList<>());
    //     for (int i = 0; i < destList.size(); i++) {
    //         String temp = destList.get(i);
    //         destList.remove(i);
    //         res.add(temp);
    //         if (f(temp, adj, res, n)) return true;
    //         res.remove(res.size() - 1);
    //         destList.add(i, temp);  // backtrack to same index
    //     }
    //     return false;
    // }


    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> adj = new HashMap<>();
        int n = tickets.size();
        // int n = tickets.size();    
        // Collections.sort(tickets,(a,b)->{
        //     if(!a.get(0).equals(b.get(0)) ){
        //         return a.get(0).compareTo(b.get(0));
        //     }
        //     return a.get(1).compareTo(b.get(1));
        // });
        for(List<String> li : tickets){
            adj.putIfAbsent(li.get(0),new PriorityQueue<>());
            adj.get(li.get(0)).add(li.get(1));
        }
        Stack<String> st = new Stack<>();

        List<String> res = new LinkedList<>();
        st.add("JFK");
        while(!st.isEmpty()){
            String src = st.peek();
            PriorityQueue<String> li = adj.get(src);
            if(li==null || li.size()==0){
                res.add(0,src);
                st.pop();
            }
            else{
                st.push(li.poll());
            }
        }
        return res;
    }
}