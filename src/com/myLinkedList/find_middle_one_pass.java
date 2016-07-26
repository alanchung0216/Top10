package com.linkedList;
/* these two class already under linkedList_length.java
 * since they are in the same package com.liskedList as
 * find_middle_one_pass.java we don't need to redefine again. 
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
*/
public class find_middle_one_pass {
/*	
	public static int findLength(myLinkedList mylist){
		int count=0;
		lnode cur = mylist.head;
		while (cur != null){
			count++;
			cur = cur.next;
		}
		return count;
	}
*/
	// when answer this question, do not implemet linkedlist
	// assume it's alread there.
	public static int find_middle_onepass(myLinkedList mylist){
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
		return cur.value;
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
		// findlength() is static so don't initialize linkedList_length
		// linkedList_length ll = new linkedList_length(); 
		System.out.println("my linked list length is "
		                   + myLinkedList_length.findLength(mylist));
		// find middle node. but this is a two pass approach
		int len = myLinkedList_length.findLength(mylist);
		lnode curr = mylist.head;
		for (int i=0; i<len/2; i++) {
			curr = curr.next;
		}
		System.out.println("two pass - my linked list mid node is "
				            + curr.value);
		// find middle node. this is one pass approach
		System.out.println("one pass - my linked list mid node is "
				            + find_middle_onepass(mylist));
	}
}

