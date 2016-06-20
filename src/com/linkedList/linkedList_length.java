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
		current.next = l;
		current = l;
	}
}
public class linkedList_length {
	
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
	}
}
