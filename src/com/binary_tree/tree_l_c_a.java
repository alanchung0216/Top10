package com.binary_tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*read 
http://www.moreofless.co.uk/binary-search-tree-bst-java/
	for how to create binary search tree. using key/value pair
	
*/
//Tree LOWEST COMMON ANCESTOR
public class tree_l_c_a {
	// input - 3, 8, 10, 20, 29, 30, 52
	// read the input and create the BST

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//String s = "30 8 52 3 20 10 29";
				//3 8 10 20 29 30 52";
		//String[] in = s.trim().split(" ");
		int[] inp = {30, 8, 52, 3, 20, 10, 29};
		BSTREE bst = new BSTREE();
	
		for (int i=0; i<inp.length; i++){
			bst.put_node(inp[i]);
		}
//		for (int i=0; i<inp.length; i++){
//			System.out.println(bst.get(inp[i]));
//		}
		File file = new File(args[0]);
		
		Scanner in = new Scanner(file);
		while (in.hasNext()) {
			int int1 = in.nextInt();
			int int2 = in.nextInt();
			in.nextLine();
			System.out.println(find_l_c_a(bst.root,int1,int2));
		}	
		in.close();			

	}
	
	public static int find_l_c_a(TNODE root, int int1, int int2){
		int low=0;
		int high=0;
		if (int1 < int2) {
			low = int1;
			high = int2;
		} else{
			low = int2;
			high= int1;
		}
        // We have found one of the nodes. The other is below, so we're done.
        if (low == root.val) {
            return root.val;
        }
        if (high == root.val) {
            return root.val;
        }		
		if (low < root.val && high > root.val) {
			return root.val;
		} else if (low < root.val && high < root.val){
			if (root.left != null)
				return find_l_c_a(root.left, int1, int2);
			else
				return root.val;
		} else if (low > root.val && high > root.val){
			if (root.right != null)
				return find_l_c_a(root.right, int1, int2);
			else
				return root.val;
		}
		return high;
	}





}
