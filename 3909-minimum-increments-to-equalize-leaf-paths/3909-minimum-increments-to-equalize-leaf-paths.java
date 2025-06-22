class Node{
    int val;
    List<Node> li ;
    public Node(int val){
        this.val = val;
        li = new ArrayList<>();
    }
}
class Solution {
    
    public long ff(Node root,int [] cost,int res[]){
        if(root.li.size()==0) return cost[root.val];
        List<Node> l = root.li;
        long maxi = 0;
        int cnt = 0;
        for(int i=0;i<l.size();i++){
            long temp = ff(l.get(i),cost,res);
            // System.out.println(l.get(i).val);
            if(temp>maxi){
                maxi = temp;
                cnt = 1;
            }
            else if(temp==maxi){
                cnt++;
            }
        }
        
        res[0] += l.size()-cnt;
        return maxi+cost[root.val];
    }
    public int minIncrease(int n, int[][] edges, int[] cost) {
        Map<Integer,Node> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new Node(i));
        }
        for(int i[] : edges){
            Node src = map.get(i[0]);
            Node des = map.get(i[1]);
            src.li.add(des);
        }
        // Node root = map.get(0);
        // long maxi = f(root,cost);
        int res[] = new int[1];
        // if(root.left==null) return 
        long left = ff(map.get(0),cost,res);
        // long right = f(root.right,cost);
        return res[0];
    }
}