package binaryTreeLAB;
/*
 * CSC 2720, Mar.22, 2017
 * Lab Instructor : Zhuojun Duan
 * 
*/

import java.util.Scanner;

public class test {
	
	public static void main(String[] args)
    {                 
        Scanner scan = new Scanner(System.in);
        /* Creating object of BST */
        binaryTree bst = new binaryTree(); 
        System.out.println("Binary Search Tree Test\n");          
        char ch;
        int flag=0;
        /*  Perform tree operations  */
        do    
        {
        	System.out.println("Enter integer element to insert.");
            bst.insert( scan.nextInt() );                     
            
            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);  
        	
        } while (ch == 'Y' || ch == 'y');  
        
        
        BTreePrinter.printNode(bst.root);
        
        
       System.out.print("Number of Nodes: ");
        System.out.println(bst.countNodes());
       

	boolean didDelete = bst.delete(4);
	if(didDelete){
       System.out.println("Deleted " );
    }else {
       System.out.println("Could not delete ");
    
       System.out.print('\n');
    }
	BTreePrinter.printNode(bst.root);
    
	
	btNode found = bst.search(3);
    if(found != null)
       {
       System.out.println("Found ");
       }
    else
       System.out.print("Could not find ");
       
    }
	
} 

