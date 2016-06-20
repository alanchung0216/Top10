package com.linkedList;

public class find_linkedlist_cycle {
	
	public static int findLength(myLinkedList mylist){
		int count=0;
		lnode cur = mylist.head;
		while (cur != null){
			count++;
			cur = cur.next;
		}
		return count;
	}
	public static boolean find_cycle(myLinkedList mylist){
		lnode cur = mylist.head;
		lnode fast = mylist.head;
		while (fast != null) {
			if (fast.next != null){
				fast = fast.next.next;
				cur = cur.next;
			}
			else
				break;
		}
		return fast == cur;
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
		// find middle node. this is one pass approach
		System.out.println("my linked list is cycle: "
				            + find_cycle(mylist));
	}
}


