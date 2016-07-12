package com.binary_tree;

import java.util.Stack;

public class postorder_traversal {
	public static void postorder_recur(TNODE tnode){
		if (tnode == null) return ;
		postorder_recur(tnode.left);
		postorder_recur(tnode.right);
		System.out.printf("%d ", tnode.val);
	}
	public static void postorder_iter(TNODE tnode){
		if (tnode == null) return;
		Stack<TNODE> st = new Stack<TNODE>();

		TNODE current = tnode;
	     while( true ) {  	    	    
	         if( current != null ) {  
	             if( current.right != null ) {  
	            	 st.push( current.right ); 
	             }
	             st.push( current );  
	             current = current.left;  
	             continue;  
	       }  
	    
	       if( st.isEmpty( ) )   
	    	   return;  
	       current = st.pop( );  
	    
	       if( current.right != null && ! st.isEmpty( ) 
	    		   && current.right == st.peek( ) ) {  
	             st.pop( );  
	             st.push( current );  
	             current = current.right;  
	       } else {  
	             System.out.print( current.val + " " );  
	             current = null;  
	       }  
	    }
	}

	public static void main(String[] args) {

		int[] input = {40, 20, 60, 10, 30, 50, 70 };
		BSTREE bst = new BSTREE();
		System.out.println("create a binary tree using these values");
		for (int i=0; i<input.length; i++){
			System.out.printf("%d ",input[i]);
		}
		System.out.println();
		for (int i=0; i<input.length; i++){
			bst.put_node(input[i]);
		}
		System.out.println("preorder traversal using recursive");
		postorder_recur(bst.root);
		System.out.println();
		System.out.println("preorder traversal using iteration");
		postorder_iter(bst.root);

		
	}

}
