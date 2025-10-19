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
   
    
    public void getNode(Node root,int target,PriorityQueue<Node> pq){
        if(root!=null){
            pq.add(root);
            getNode(root.left,target,pq);
            getNode(root.right,target,pq);
        }
    }
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
       
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
            int dif = Integer.compare(Math.abs(target - a.data),Math.abs(target - b.data) ) ;
            if(dif!=0){
                return  dif;
            }
            return Integer.compare(a.data,b.data);
        } );
        getNode(root,target,pq);
        
        ArrayList<Integer> res = new ArrayList<>();
        
        while(!pq.isEmpty() && k-->0){
            
            res.add(pq.poll().data);
        }
        return res;
    }
}