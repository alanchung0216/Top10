package com.binary_tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class TNODE {
	int val;
	TNODE left;
	TNODE right;	
	public TNODE (int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
	public void put(int i){
		if (i < val){
			if (left != null){
				left.put(i);
			} else {
				left = new TNODE(i);
			}
		} else if (i > val){
			if (right != null){
				right.put(i);
			} else {
				right = new TNODE(i);
			}
		} else
			val = i;
		
	}
	public int get(int i){
		if (i < val) {
			return (left == null) ? null : left.get(i);
		} else if (i > val){
			return (right == null) ? null : right.get(i);
		} else
			return val;
		
	}
}
class BSTREE {
	TNODE root;
	public void put_node(int i){
		if (root == null)
			root = new TNODE(i);
		else
			root.put(i);
	}
	public int get_node(int i){
		return (root == null) ? null : root.get(i);
	}
}
public class bst_create_search {
	public static void main(String[] args){
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
		System.out.println("search BST using these values");
		for (int i=0; i<input.length; i++){
			System.out.printf("%d ",input[i]);
		}
		System.out.println();
		System.out.println("here are the results");
		for (int i=0; i<input.length; i++){
			System.out.printf("%d ",bst.get_node(input[i]));
		}
		System.out.println();
	}
	
}
