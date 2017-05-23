package binaryTreeLAB;
/*
 * CSC 2720, Mar.22, 2017
 * Lab Instructor : Zhuojun Duan
 * 
*/

public class btNode {

	btNode left, right;
    int data;

    /* Constructor */
    public btNode()
    {
        left = null;
        right = null;
        data = 0;
    }
    /* Constructor */
    public btNode(int n)
    {
        left = null;
        right = null;
        data = n;
    }
    /* Function to set left node */
    public void setLeft(btNode n)
    {
        left = n;
    }
    /* Function to set right node */ 
    public void setRight(btNode n)
    {
        right = n;
    }
    /* Function to get left node */
    public btNode getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public btNode getRight()
    {
        return right;
    }
    /* Function to set data to node */
    public void setData(int d)
    {
        data = d;
    }
    /* Function to get data from node */
    public int getData()
    {
        return data;
    }
    
    
}
