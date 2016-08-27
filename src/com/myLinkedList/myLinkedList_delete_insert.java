package com.myLinkedList;

public class myLinkedList_delete_insert {
	public static myLinkedList insertNode(myLinkedList list, int val){
		lnode current = list.head;
		lnode pre = current;
		while (current != null) {
			if (current.value == val) {
				pre.next = new lnode(val-1);
				pre = pre.next;
				pre.next = current;
				break;
			} 
			pre = current;
			current = current.next;
			
		}
		return list;
		
		
	}
	public static myLinkedList removeNode(myLinkedList list, int val){
		lnode head = list.head;
		lnode current = head;
		lnode pre = current;
		while (current != null) {
			if (current.value > val){
				pre.next  = current.next;
				//current = current.next.next;
				current = pre;
			}
			pre = current;
			current = current.next;
		}
		return list;
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
		// remove node value >7
		myLinkedList newList = removeNode(mylist, 7);
		// insert some value before first encountered value
		newList = insertNode(mylist, 6);
		lnode curr = newList.head;
		while (curr != null) {
			System.out.println("my linked list node is "
					+ curr.value);
			curr = curr.next;
		}
	}
}
