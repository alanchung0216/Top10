 package com.binary_tree;

import java.util.LinkedList;
import java.util.Stack;

import java.util.Queue;

/*
We will use Queue for Level Order traversal.
This algorithm is very similar to Breadth first search of graph.

Steps for Level order traversal algorithm:

Create empty queue and pust root node to it.
Do the following when queue is not empty
Pop a node from queue and print it
Push left child of popped node to queue if not null
Push right child of popped node to queue if not null

*/
public class level_order_traversal {

	public static void levelorder_iter(TNODE tnode){
		if (tnode == null) return;
		Queue<TNODE> st = new LinkedList<TNODE>();
		st.add(tnode);
		while (st.size() != 0){
			TNODE top = st.poll();
			System.out.printf("%d ",top.val);
			if (top.left != null)
				st.add(top.left);
			if (top.right != null)
				st.add(top.right);
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

		System.out.println("level order traversal using iteration");
		levelorder_iter(bst.root);

		
	}

}
