package com.linkedList;

class lnode {
	public int value;
	public lnode next;
	lnode () {
		value = 0;
		next = null;
	}
	lnode (int v) {
		value = v;
		next = null;
	}
}
class myLinkedList {
	lnode head;
	lnode current;
	
	myLinkedList () {
		head = null;
		current = null;
	}
	void addNode (lnode l) {
		if (head == null) {
			head = l;
			current = l;
			return;
		}
		current.next = l; // important, do change order
		current = l; // important, do change order
	}
}
public class myLinkedList_length {
	
	public static int findLength(myLinkedList mylist){
		int count=0;
		lnode cur = mylist.head;
		while (cur != null){
			count++;
			cur = cur.next;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myLinkedList mylist = new myLinkedList();
		// add nodes to form a linked list
		mylist.addNode(new lnode(5));
		mylist.addNode(new lnode(6));
		mylist.addNode(new lnode(7));
		mylist.addNode(new lnode(8));
		mylist.addNode(new lnode(9));
		System.out.println("my linked list length is "
		                   + findLength(mylist));
		// find middle node. but this is a two pass approach
		int len = findLength(mylist);
		lnode curr = mylist.head;
		for (int i=0; i<len/2; i++) {
			curr = curr.next;
		}
		System.out.println("my linked list mid node is "
				            + curr.value);
	}
}
