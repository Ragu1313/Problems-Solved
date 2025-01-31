/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public int count(Node node){
        Set<Node> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        set.add(node);
        int cnt = 1;
        while(!q.isEmpty()){
            Node p = q.poll();
            for(Node i : p.neighbors){
                if(set.add(i)){
                    q.add(i);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void f(Node node,Map<Integer,Node> map){
        Set<Node> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        set.add(node);
        while(!q.isEmpty()){
            Node p = q.poll();
            for(Node i : p.neighbors){
                if(set.add(i))
                    q.add(i);
                    // map.get(i.val).neighbors.add(map.get(p.val));
                    map.get(p.val).neighbors.add(map.get(i.val));
                // }
            }
        }
    }
    public Node cloneGraph(Node node) {
        Node res = new Node();
        if(node==null){
            return null;
        }
        Map<Integer,Node> map = new HashMap<>();
        int n =  count(node);
        for(int i=0;i<n;i++){
            map.put(i+1,new Node(i+1));
        }
        f(node,map);
        return map.get(node.val);
    }
}