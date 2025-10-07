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
class Pair{
    int level ;
    Node root;
    public Pair(int level , Node node){
        this.level = level;
        this.root = node;
    }
}
class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    // public void f(int width , Node root){
    //     if(root!=null){
    //         map.put(width,root.data);
    //         f(width-1,root.left);
    //         f(width+1,root.right);
    //     }
    // }
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->(a[0] - b[0]));
        // f(0,root);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            map.put(temp.level,temp.root.data);
            if(temp.root.left!=null){
                Pair dup = new Pair(temp.level-1,temp.root.left);
                q.add(dup);
            }
            if(temp.root.right!=null){
                Pair dup = new Pair(temp.level+1,temp.root.right);
                q.add(dup);
            }
        }
        for(int i : map.keySet()){
            p.add(new int[]{i,map.get(i)});
        }
        while(!p.isEmpty()){
            res.add(p.poll()[1]);
        }
        return res;
    }
}