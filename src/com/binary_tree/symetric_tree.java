package com.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class symetric_tree {
	public static boolean isSymmetric(TNODE root) {
		if (root == null)
			return true;
		return isSymmetric_recur(root.left, root.right);
	}
	 
	public static boolean isSymmetric_recur(TNODE l, TNODE r) {
		if (l == null && r == null) {
			return true;
		} else if (r == null || l == null) {
			return false;
		}
	 
		if (l.val != r.val)
			return false;
	 
		if (!isSymmetric_recur(l.left, r.right))
			return false;
		if (!isSymmetric_recur(l.right, r.left))
			return false;
	 
		return true;
	}
	
	public static boolean isSymmetricIter(TNODE root){
		if (root == null) return true;
		
		Queue<TNODE> q = new LinkedList<TNODE>();
		q.offer(root.left);
		q.offer(root.right);
		while (!q.isEmpty()){
			TNODE l = q.poll();
			TNODE r = q.poll();
			if (l == null && r == null) return true;
			else if (l == null || r == null) return false;
			if (l.val != r.val ) return false;
			
			if (l != null && r != null) {
				q.offer(l.left);
				q.offer(l.right);
				q.offer(r.left);
				q.offer(r.right);
			}
		}
		return true;
	}

	/*
	
	public static boolean isSymmetricIter(TNODE root) {
	    boolean result = false;

	    if (root == null) {
	        result = true;
	    }

	    Queue<TNODE> queue = new LinkedList<TNODE>();
	    queue.offer(root.left);
	    queue.offer(root.right);

	    while (!queue.isEmpty()) {
	    	TNODE left = queue.poll();
	    	TNODE right = queue.poll();

	        if (left == null && right == null) {

	            result = true;

	        }
	        else if (left == null || 
	                right == null || 
	                left.val != right.val) {
	            // It is required to set result = false here
	            result = false;
	            break;
	        }

	        else if (left != null && right != null) {
	            queue.offer(left.left);
	            queue.offer(right.right);

	            queue.offer(left.right);
	            queue.offer(right.left);
	        }
	    }

	    return result;
	}	
	*/

	public static void main(String[] args) {
		//int[] input = {40, 20, 60, 10, 30, 50, 70 };
		int[] input = {20, 20, 20, 20, 20, 20}; // symetric - true
		BSTREE bst = new BSTREE();
		System.out.println("create a binary tree using these values");
		for (int i=0; i<input.length; i++){
			System.out.printf("%d ",input[i]);
		}
		System.out.println();
		for (int i=0; i<input.length; i++){
			bst.put_node(input[i]);
		}
		System.out.println("is tree symetric recursive: "+isSymmetric(bst.root));
		System.out.println("is tree symetric using iter: "+isSymmetricIter(bst.root));

		System.out.println();

	}

}
