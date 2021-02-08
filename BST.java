

public class BST {
  Node root;

  public static void main(String[] args) {
    BST bst = new BST();
    bst.insert(5);
    bst.insert(10);
    bst.insert(12);
    bst.insert(15);
    bst.insert(3);
    bst.insert(4);
    bst.insert(9);
    bst.insert(1);
    bst.inOrder();
    //System.out.println(bst.findMin());
    //System.out.println(bst.findMax());
   // bst.postOrder();
   // bst.size();
   // int res = bst.height();
   // System.out.println(res);
    
    //int res1 = bst.size();
    //System.out.println(res1);
    //bst.insert(7);
    

  }
  
  public int size() {
    return sizeHelper(root);
  }
  
  private int sizeHelper(Node n) {
    if(n == null) {
      return 0;
    }
    return sizeHelper(n.left) + 1 + sizeHelper(n.right);
  }
  
  public int height() {
    return heightHelper(root);
  }
  
  private int heightHelper(Node root) {
    if(root == null) {
      return -1;
    }
    return 1 + Math.max(heightHelper(root.left), heightHelper(root.right));
  }
  

  public int findMin() {
    Node current = root;
    while(current.left != null) {
      current = current.left;
    }
    return current.data;
  }
  
  public int findMax() {
    Node current = root;
    while(current.right != null) {
      current = current.right;
    }
    return current.data;
  }
  
  public void inOrder() {
    inOrderHelper(root);
  }
  
  public void inOrderHelper(Node n) {
    String res ="";
    if(n == null) {
      return;
    }
    inOrderHelper(n.left);
    res = res +n.data;
    System.out.print(n.data+" ");
    inOrderHelper(n.right);
  }
  
  public void postOrder() {
    postOrderHelper(root);
  }
  
  public void postOrderHelper(Node n) {
    if(n == null) {
      return;
    }
    postOrderHelper(n.left);
    postOrderHelper(n.right);
    System.out.print(n.data+" ");
  }

  public Node lookup(int key) {
    try {
      return lookupHelper(root, key);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
  
  public Node lookupHelper(Node n, int key) throws Exception {
    if(n == null) throw new Exception(" key not found");
    
    if(key < n.data) {
      return lookupHelper(n.left, key);
    } else if(key > n.data) {
      return lookupHelper(n.right, key);
    } else {
      return n;
    }
    
  }
  
  public void insert(int key) {
    if(root == null) root = new Node(key);
    else insertHelper(root, key);
  }
  
  public void insertHelper(Node n, int key) {
    if(key < n.data) {
     if(n.left == null)
       n.left = new Node(key);
     else
       insertHelper(n.left, key);
    } else if(key > n.data) {
      if(n.right == null)
        n.right = new Node(key);
      else
        insertHelper(n.right, key);
    }
  }


}


