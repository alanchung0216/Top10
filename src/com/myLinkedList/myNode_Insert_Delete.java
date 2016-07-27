package com.myLinkedList;

class Node {
	int val;
	Node next;
	Node(int val, Node next){
		this.val = val;
		this.next = next;
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
public class simpleList_Insert_Delete {
	public static void add(SimpleList sl,Node n) {
		if (sl.head == null){
			sl.head.val = n.val;
			sl.head.next = n.next;
			sl.current = sl.head;
		} else {
			sl.current.next = n;			
		}
	}
	public static void remove(SimpleList sl, 7) {
		
	}

	public static void main(String[] args) {
		// create a list
		// create a head node
		SimpleList sl = new SimpleList();
		Node node = new Node(5, null);
		// add one node
		add(sl, node);
		add(sl, new Node(6, null));
		add(sl, new Node(7, null));
		add(sl, new Node(8, null));
		add(sl, new Node(9, null));
		// remove value > 7
		remove(sl, 7);
		
		

	}

}
