/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

// class Pair{
//     String s ;
//     int val;
//     public Pair(String s , int val){
//         this.s = s;
//         this.val = val;
//     }
// }

class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int get(Node root ,int flag){
        if(root==null)  return 0;
        String s = String.valueOf(root) + String.valueOf(flag);
        if(map.get(s)!=null){
            return map.get(s);
        }
        if(root!=null){
            int maxi = 0;
            maxi += get(root.left,0) + get(root.right,0) ;
            if(flag==0){
                maxi = Math.max(maxi,get(root.left,1) + get(root.right,1) + root.data );
            }
            map.put(s,maxi);
            return  map.get(s);
        }
        map.put(s,0);
        return 0;
    }
    public int getMaxSum(Node root) {
        return get(root,0);
    }
}