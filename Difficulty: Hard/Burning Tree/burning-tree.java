/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static void f(Node root,Map<Node,Node> map,int tar,Queue<Node> q){
        if(root==null)  return ;
        if(root.data==tar)  q.add(root);
        if(root.left!=null) { map.put(root.left,root); f(root.left,map,tar,q);}
        if(root.right!=null) { map.put(root.right,root); f(root.right,map,tar,q);}
    }
    public static int minTime(Node root, int tar) {
        // code here
        Map<Node,Node> map = new HashMap<>();
        map.put(root,null);
        Queue<Node> q = new LinkedList<>();
        f(root,map,tar,q);
        int time = -1;
        Set<Node> set = new HashSet<>();
        if(!q.isEmpty())
        set.add(q.peek());
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            while(size-->0){
                Node temp = q.poll();
                if(temp.left!=null && set.add(temp.left)){
                    q.add(temp.left);
                }
                if(temp.right!=null && set.add(temp.right)){
                    q.add(temp.right);
                }
                Node par = map.get(temp);
                if(par!=null && set.add(par)){
                    q.add(par);
                }
            }
        }
        return time;
    }
}