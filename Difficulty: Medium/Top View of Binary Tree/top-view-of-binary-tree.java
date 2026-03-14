/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Pair {
    Node node;
    int dist;
    Pair(Node node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(0, root.data);
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.dist;
            
            if(curr.left != null){
                if(!map.containsKey(hd - 1)) map.put(hd - 1, curr.left.data);
                q.offer(new Pair(curr.left, hd - 1));
            }
            if(curr.right != null){
                if(!map.containsKey(hd + 1)) map.put(hd + 1, curr.right.data);
                q.offer(new Pair(curr.right, hd + 1));
            }
        }
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }
}