package com.myLinkedList;

class Node {
	int val;
	Node next;
	Node(int val){
		this.val = val;
		next = null;
	}
	public String toString(){
		return String.valueOf(val);
	}
}

class SimpleList {
	Node head;
	Node current;
	SimpleList(){
		head = null;
		current = null;
	}
}
public class myNode_Insert_Delete {
	public static void showList(Node n){
		Node head = n;
		while (head != null){
			System.out.println(head);
			head = head.next;
		}
		System.out.println();
	}
	public static void add_no_return(Node n, int val) {
		// only add to the end
		Node head = n;
		while (head != null){
			if (head.next == null){
				head.next = new Node(val);
				return;
			}
			head = head.next;
		}
		return;
		
	}
	
	public static  void insert_no_return(Node n, int val, int newVal){
		// be careful about insert
		// when you do insert you need to have
		// info about previous node so that
		// it can have correct link to the new node.
		
		// hear we want to insert new node before val
		Node head = n;
		Node pre = head;
		while (head != null) {
			if (head.val == val) {
				if (pre == head) { // first node
					pre = new Node(newVal);
					pre.next = head;
					n = pre; // this would not work because
							// n is copy and caller will still
							// get original n
							// solution is return new Node
				} else {
					pre.next = new Node(newVal);
					pre.next.next = head;
					return; // done
				}
			} else {
				pre = head;
				head = head.next;
				
			}
		}
	}


	public static void remove_no_return(Node n, int val) {
		
		// note return void would not work
		// because n is call by value
		// caller will get old copy n
		// solution is to return new Node
		// however this would work if we don't
		// change head and simply remove
		// NON head nodes.
		
		// be careful about delete
		// when you do delete you need to have
		// previous node info so that it can
		// link to the correct next node
		
		// here we want to delete node that value
		// is greater than val
		Node head = n;
		Node pre = head;
		while (head != null) {
			if (head.val > val) {
				if (pre == head){ // the first one
					head = head.next;
					pre = pre.next;
					n = head;	// node this would not work
								// because n is call by value
								// caller will get old copy n
								// solution is to return new Node
				} else {
					pre.next = head.next;
					head = head.next;
				}
				
			} else {
				pre = head;
				head = head.next;
				
			}			
		}
	}
	public static Node add(Node n, int val) {
		// only add to the end
		Node orig = n;
		Node head = orig;
		while (head != null){
			if (head.next == null){
				head.next = new Node(val);
				return orig;
			}
			head = head.next;
		}
		return orig;
		
	}	
	public static Node insert(Node n, int val, int newVal){
		// we want to return modified node because
		// head node "n" may be changed by insert
		//
		// be careful about insert
		// when you do insert you need to have
		// info about previous node so that
		// it can have correct link to the new node.
		
		// hear we want to insert new node before val
		Node orig = n;
		Node head = orig;
		Node pre = head;
		while (head != null) {
			if (head.val == val) {
				if (pre == head) { // first node
					pre = new Node(newVal);
					pre.next = head;
					orig = pre;
					return orig; // done

				} else {
					pre.next = new Node(newVal);
					pre.next.next = head;
					return orig; // done
				}
			} else {
				pre = head;
				head = head.next;
				
			}
		}
		return orig;
	}


	public static Node remove(Node n, int val) {
		
		// we want to return modified node because
		// head node "n" may be changed by remove
		//
		
		// be careful about delete
		// when you do delete you need to have
		// previous node info so that it can
		// link to the correct next node
		
		// here we want to delete node that value
		// is greater than val
		Node orig = n;
		Node head = orig;
		Node pre = head;
		while (head != null) {
			if (head.val > val) {
				if (pre == head){ // the first one					
					head = head.next;
					pre = pre.next;
					orig = head;
				} else {
					pre.next = head.next;
					head = head.next;
				}
				
			} else {
				pre = head;
				head = head.next;
				
			}			
		}
		return orig;
	}

	public static void main(String[] args) {

		// let's to create a linkedlist just using Node
		// every lookup will start from head which is a drawback
		
		System.out.println("create first node 5");
		Node node = new Node(5);
		// add one node
		
		System.out.println("add 6, 7, 8 to the end");
		add_no_return(node,6);
		add_no_return(node,7);
		add_no_return(node,8);
		showList(node);
		
		System.out.println("remove value > 7");
		remove_no_return(node, 7);
		showList(node);
		
		System.out.println("add 1, 2 to the end");
		add_no_return(node,1);
		add_no_return(node,2);
		showList(node);
		
		// test if we handle head correctly
		// remove_no_return(node, 4) would not work
		// because head 5 will be chopped off
		System.out.println("remove value > 4, head should be impacted");
		remove_no_return(node, 4);
		showList(node);
		System.out.println("remove value > 4, head not impacted, why?\n");
		
		System.out.println("remove value > 5, head not impacted");
		remove_no_return(node, 5);
		showList(node);
		
		// what if we could not find > val
		// nothing changed
		System.out.println("remove value > 12, nothing changed");
		remove_no_return(node, 12);
		showList(node);
		
		System.out.println("insert 7 before 1");
		// let's insert 7 before 1
		
		insert_no_return(node, 1, 7);
		showList(node);
	
		// let's test if we handle head correctly
		// insert_no_return(node, 5, 7) would not work
		// because head got changed.
		System.out.println("insert 7 before 5, head should be impacted");
		insert_no_return(node, 5, 7);
		showList(node);
		System.out.println("insert 7 before 5, head not impacted, why?\n");
		
		System.out.println("insert 9 before 2");
		insert_no_return(node, 2, 9);
		showList(node);	
		
		// what if we could not find the val
		// nothing changed.
		System.out.println("insert 11 before 8, nothing changed");
		insert_no_return(node, 8, 11);
		showList(node);	
		
		System.out.println("let's try the same operations");
		
		System.out.println("remove all first");		
		node = null;
		showList(node);
		
		// let's to create a linkedlist just using Node
		// every lookup will start from head which is a drawback
		
		System.out.println("create first node 5");
		node = new Node(5);
		// add one node
		/*
		 * create first node 5
add 6, 7, 8 to the end
7
8
		 */
		System.out.println("add 6, 7, 8 to the end");
		node = add(add(add(node,6),7),8);
		showList(node);
		
		System.out.println("remove value > 7");
		
		node = remove(node, 7);
		showList(node);
		
		System.out.println("add 1, 2 to the end");
		node = add(add(node,1),2);
		showList(node);
		
		// test if we handle head correctly
		// remove_no_return(node, 4) would not work
		// because head 5 will be chopped off
		System.out.println("remove value > 4, head should be impacted");
		
		node = remove(node, 4);
		showList(node);
		
		System.out.println("remove value > 5, head not impacted");
		
		node = remove(node, 5);
		showList(node);
		
		// what if we could not find > val
		// nothing changed
		System.out.println("remove value > 12, nothing changed");
		node = remove(node, 12);
		showList(node);
		
		System.out.println("insert 7 before 1");
		// let's insert 7 before 1
		
		node = insert(node, 1, 7);
		showList(node);
	
		// let's test if we handle head correctly
		// insert_no_return(node, 5, 7) would not work
		// because head got changed.
		System.out.println("insert 7 before 5");
		
		node = insert(node, 5, 7);
		showList(node);
		
		System.out.println("insert 9 before 2");
		
		node = insert(node, 2, 9);
		showList(node);	
		
		// what if we could not find the val
		// nothing changed.
		System.out.println("insert 11 before 8, nothing changed");
		
		node = insert(node, 8, 11);
		showList(node);	
		

	}

}
