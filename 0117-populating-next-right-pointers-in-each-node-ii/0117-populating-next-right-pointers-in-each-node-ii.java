/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root!=null)
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size()-1;
            Node node = q.poll();
            // System.out.println(node.val);
            if(node.left!=null)
            q.add(node.left);
            if(node.right!=null)
            q.add(node.right);
            while(size-->0){
                Node temp = q.poll();
                // System.out.println(temp.val);
                node.next = temp;
                node = node.next;
                if(node.left!=null)
                q.add(node.left);
                if(temp.right!=null)
                q.add(temp.right);
            }
            node.next = null;    
        }
    }
    public Node connect(Node root) {
        if(root==null) return null;
        bfs(root);
        return root;
    }
}
// class Solution {
//     public Node connect(Node root) {
        
//     }
// }