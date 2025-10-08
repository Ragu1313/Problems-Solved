/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    Node head = null;
    
    public void build(int poi[],int pre[],int post[],Node node){
        if(poi[0]>=pre.length){
            return ;
        }
        if(map.get(pre[poi[0]])<map.get(node.data)){
            Node temp = new Node(pre[poi[0]]);
            node.left = temp;
            poi[0]++;
            // System.out.println(temp.data);
            build(poi,pre,post,node.left);
        }
        if(map.get(pre[poi[0]])<map.get(node.data)){
            Node temp = new Node(pre[poi[0]]);
            node.right = temp;
            poi[0]++;
            build(poi,pre,post,node.right);
        }
        
    } 
    public Node constructTree(int[] pre, int[] post) {
        int n = pre.length;
        for(int i=0;i<n;i++){
            map.put(post[i],i);
        }
        head = new Node(pre[0]);
        int arr1[] = new int[1];
        arr1[0] = 1;
        build(arr1,pre,post,head);
        return head;
    }
}