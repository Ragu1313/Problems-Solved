class Node{
  int data;
  Node left;
  Node right;
  public  Node(int data){
    this.data = data;
  }
  
}

class BinaryTree{
  Node root;
  public Node getRoot(){
    return root;
  }
  public void insert(int data){
    root = insertNode(root,data);
  }
  public Node insertNode(Node root,int data){
    if(root==null){
      root = new Node(data);
    }
    else if (data < root.data){
      root.left = insertNode(root.left, data);
    }
    else if (data > root.data){
      root.right = insertNode(root.right, data);
    }
    return root;
  }
  public void inOrder(){
      inOrderTraversal(root);
  }
  public void inOrderTraversal(Node root){
    if(root!=null){
    inOrderTraversal(root.left);
    System.out.println(root.data + " ");
    inOrderTraversal(root.right);
    }
  }
  public Node leastCommonAncesterNode(Node root,int x,int y){
    if(x<root.data && y<root.data)
      return leastCommonAncesterNode(root.left, x, y) ;
    if(x>root.data && y>root.data)
      return leastCommonAncesterNode(root.right, x, y);
    return root;   
  }
}
public class Tree{
  public static void main(String[] args) {

    BinaryTree a = new BinaryTree();
    a.insert(50);
    a.insert(30);
    a.insert(60);
    a.insert(20);
    a.insert(70);
    a.insert(100);
    a.inOrder();
    System.out.println();
    System.out.println(a.getRoot());
    System.out.println(a.leastCommonAncesterNode(a.getRoot(),20,30).data);
  }
}