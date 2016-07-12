package com.binary_tree;

import java.util.Stack;

/*
this is one of DFS approach
beause it use Stack you can solve it via recursive

Steps for PreOrder traversal are:
Visit the node.
Traverse the left subtree in PreOrder.
Traverse the right subtree in PreOrder.
*/

public class preorder_traversal {
	public static void preorder_recur(TNODE tnode){
		if (tnode == null) return ;
		System.out.printf("%d ", tnode.val);
		preorder_recur(tnode.left);
		preorder_recur(tnode.right);
	}
	public static void preorder_iter(TNODE tnode){
		if (tnode == null) return;
		Stack<TNODE> st = new Stack<TNODE>();
		st.push(tnode);
		while (!st.empty()){
			TNODE top = st.pop();
			System.out.printf("%d ",top.val);
			if (top.right != null)
				st.push(top.right);
			if (top.left != null)
				st.push(top.left);
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
		preorder_recur(bst.root);
		System.out.println();
		System.out.println("preorder traversal using iteration");
		preorder_iter(bst.root);

		
	}

}
