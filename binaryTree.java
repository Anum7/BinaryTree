package binaryTreeLAB;
/*
 * CSC 2720, Mar.22, 2017
 * Lab Instructor : Zhuojun Duan
 * 
*/

public class binaryTree {
	
	protected btNode root;
	 
    /* Constructor */
    public binaryTree()
    {
        root = null;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Functions to insert data */
    public void insert(int data)
    {
        root = insert(root, data);
    }
    
    
    /* Function to insert data recursively */
    private btNode insert(btNode node, int data)
    {
        if (node == null)
            node = new btNode(data);
        else
        {
            if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }
   
  
    /*
     * Students in the LAB should complete three methods as follows
     */
   
    
   //count number of nodes in the tree
    public int countNodes(){
    	return count(root);
    }
    
    public int count(btNode root) {
        if(root==null)
            return 0;
     
        int left = getLeftHeight(root)+1;    
        int right = getRightHeight(root)+1;
     
        if(left==right){
            return (2<<(left-1))-1;
        }else{
            return count(root.left)+count(root.right)+1;
        }
    }
    public int getLeftHeight(btNode n){
        if(n==null) return 0;
     
        int height=0;
        while(n.left!=null){
            height++;
            n = n.left;
        }
        return height;
    }
     
    public int getRightHeight(btNode n){
        if(n==null) return 0;
     
        int height=0;
        while(n.right!=null){
            height++;
            n = n.right;
        }
        return height;
    }
    
   //search for a node with key m and return it
    public btNode search(int m){     
                               
    System .out.println("We are searching for " + m);
    btNode current = root;               
    while(current.getData() != m)        
       {
       if(m < current.getData())         
          current = current.getLeft();
       else                            
          current = current.getRight();
       if(current == null)             
          return null;                 
       }
    return current;                   
    } 
   
 // delete the node with key m
   public boolean delete(int m) {
                              
   System.out.println("We are deleting " + m);
	btNode current = root;
    btNode parent = root;
    boolean LeftChild = true;

    while(current.getData() != m)        
       {
       parent = current;
       if(m < current.getData())         
          {
          LeftChild = true;
          current = current.left;
          }
       else  {                          
          LeftChild = false;
          current = current.right;
          }
       if(current == null)             
          return false;                
       }  // end while
    // found node to delete

    // if no children, simply delete it
    if(current.left==null && current.right==null)
       {
       if(current == root)             // if root,
          root = null;                 // tree is empty
       else if(LeftChild)
          parent.left = null;     // disconnect
       else                            // from parent
          parent.right = null;
       }

    // if no right child, replace with left subtree
    else if(current.right==null)
       if(current == root)
          root = current.left;
       else if(LeftChild)
          parent.left = current.left;
       else
          parent.right = current.left;

    // if no left child, replace with right subtree
    else if(current.left==null)
       if(current == root)
          root = current.right;
       else if(LeftChild)
          parent.left = current.right;
       else
          parent.right = current.right;

    else  // two children, so replace with inorder successor
       {
       // get successor of node to delete (current)
       btNode successor = getNext(current);

       // connect parent of current to successor instead
       if(current == root)
          root = successor;
       else if(LeftChild)
          parent.left = successor;
       else
          parent.right = successor;

       // connect successor to current's left child
       successor.left = current.left;
       }  // end else two children
    // (successor cannot have a left child)
    return true;                                // success
    }  // end delete()
    
    private btNode getNext(btNode delNode)
    {
    btNode nextParent = delNode;
    btNode next = delNode;
    btNode current = delNode.right;   // go to right child
    while(current != null)               // until no more
       {                                 // left children,
       nextParent = next;
       next = current;
       current = current.left;      // go to left child
       }
                                         // if successor not
    if(next != delNode.right)  // right child,
       {                                 // make connections
       nextParent.left = next.right;
       next.right = delNode.right;
       }
    return next;
    } 
}

