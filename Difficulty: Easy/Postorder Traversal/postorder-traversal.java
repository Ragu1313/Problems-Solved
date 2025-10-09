/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> arr ;
    public void post(Node node){
        if(node!=null){
            post(node.left);
            post(node.right);
            arr.add(node.data);
        }
    }
    public ArrayList<Integer> postOrder(Node root) {
        arr = new ArrayList<>();
        post(root);
        return arr;
    }
}