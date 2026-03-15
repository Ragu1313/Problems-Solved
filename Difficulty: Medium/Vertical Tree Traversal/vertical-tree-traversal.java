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
    int ver;
    Node node;
    public Pair(int ver,Node node){
        this.ver = ver;
        this.node = node;
    }
}

class Solution {
    TreeMap<Integer,ArrayList<Integer>> treeMap ;
    
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null)  return res;
        treeMap = new TreeMap<>();
        
        treeMap.put(0,new ArrayList<>());
        treeMap.get(0).add(root.data);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        
        while(!q.isEmpty()){
            Pair temp = q.poll();
            if(temp.node.left!=null){
                q.add(new Pair(temp.ver-1,temp.node.left));
                treeMap.putIfAbsent(temp.ver-1,new ArrayList<>());
                treeMap.get(temp.ver-1).add(temp.node.left.data);
            }
            if(temp.node.right!=null){
                q.add(new Pair(temp.ver+1,temp.node.right));
                treeMap.putIfAbsent(temp.ver+1,new ArrayList<>());
                treeMap.get(temp.ver+1).add(temp.node.right.data);
            }
        }
        
        
        int ind = 0;
        for(int i : treeMap.keySet()){
            res.add(new ArrayList<>());
            for(int j : treeMap.get(i)){
                res.get(ind).add(j);
            }
            ind++;
        }
        return res;
    }
}