/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Deque<Integer> d = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(root.data);
        int cnt = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Node temp = q.poll();
                if(temp.left!=null){
                    d.add(temp.left.data);
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    d.add(temp.right.data);
                    q.add(temp.right);
                }
                
            }
            if((cnt&1)==1){
                while(d.size()>0){
                    res.add(d.pollLast());
                }
            }
            else{
                while(d.size()>0){
                    res.add(d.pollFirst());
                }
            }
            cnt++;
        }
        return res;
    }
}