package com.hashmap;
/*
keep track 10 latest trade price for IBM, APPLE etc
use HashMap<String,Linkedlist<Integer>>
use ls.addFirst to insert price to the head
when key in IBM then get Value using hm.getValue.sublist(0,10);
this will get the latest 10 prices.

I did it wrong because I got confused this Price list with
conflict linked list. They are different things because even there is a conflict
(ex. IBM key and APPLY key both have same hashcode value) the conflict
list is handled by HashMap internal (as user we don’t see conflict). After
item is identified (ex. IBM) on the conflict linked list using equals method 
(in this case it’s default String equal method) user will get the IBM value 
(LinkedList<Integer>) and insert the current price in the head of the price list. 

Note the whole question is asking how to design the LRU Cache.
LRU is Least Recent Used eviction policy. When you insert current price 
in the head of list you are putting most recent used in front so when you 
need to evict LRU item to gain memory you simply remove the tail of the list. 
 */
public class LRU_Cache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
