package com.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverse_level_traversal {

	public static void rev_levelorder_iter(TNODE tnode){
	
		if (tnode == null) return;
		
		Queue<TNODE> q = new LinkedList<TNODE>();
		Stack<TNODE> st = new Stack<TNODE>();
		
		q.add(tnode);
		
		while (q.size() != 0) {
			TNODE top = q.poll();
			if (top.right != null) {
				q.add(top.right);
			}
			if (top.left != null) {
				q.add(top.left);
			}
			st.push(top);
		}
		while (!st.empty()) {
			System.out.printf("%d ", st.pop().val);
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
		rev_levelorder_iter(bst.root);
	
	}
}
