package com.binary_tree;

import java.util.Stack;

public class inorder_traversal {

	public static void inorder_recur(TNODE tnode){
		if (tnode == null) return ;
		inorder_recur(tnode.left);
		System.out.printf("%d ", tnode.val);
		inorder_recur(tnode.right);
	}
	public static void inorder_iter(TNODE tnode){
		if (tnode == null) return;
		Stack<TNODE> st = new Stack<TNODE>();
		TNODE current = tnode;
		while (!st.empty() || current != null){// use this to get into deep to left
			if (current != null) {
				st.push(current);
				current = current.left; // keep going left
			} else {
				TNODE top = st.pop(); // reach end of left, now take top to print value
				System.out.printf("%d ",top.val);
				current = top.right; // move it to the right
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
		System.out.println("inorder traversal using recursive");
		inorder_recur(bst.root);
		System.out.println();
		System.out.println("inorder traversal using iteration");
		inorder_iter(bst.root);		
	}

}
