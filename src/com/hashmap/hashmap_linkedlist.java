package com.hashmap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/*
Ok got what you are saying 
So if i want to use collison ( and hence not override values for keys ) 
i need to specify what data structure should be used for values 
(as they can be more than one ) 
as you suggested 

HashMap<String, List<String>> hm = new HashMap<String, List<String>>();

or may be if i want ordered storage of values for a given key i should use 

HashMap<String, TreeSet<String>> hm =
   new HashMap<String, TreeSet<String>>();  // to store in sorted order
HashMap<String, LinkedHashSet<String>> hm =
   new HashMap<String, LinkedHashSet<String>>(); // to store in insertion order 

and then iterate through each DataStructure of values ( for a key ) and print same 
right ?
 */
/*
NY exchange:

IBM  US Equity 
AAPL US Equity
…
active security, are traded many times every day and trade prices keep changed too.

Keep trace of latest 10 trade price for all securities, so that applications can easily query it.
*/
/*
class Node {
	int price;
    Node next;
    Node(Trade td){
        this.td = td;
        next = null;
    }
}

class myLinkedList {
    Node head;
    Node current;
    myLinkedList() {
        head=null;
        current=null;
    }
    void addNode (Node l) {
        if (head == null) {
            head =l;
            current = l;
            return;
        }
        current.next = l;
        current = l;
    }
}
*/

class Trade {
    String ticker;
    int price;
    Trade(String str, int p){
        this.ticker = str;
        this.price = p;
    }
    @Override
    public int hashCode(){
    	System.out.print("hashed");
    	return Integer.valueOf(this.price)*1371;
    	//return 2;
    }
    @Override   
    public boolean equals(Object obj) {

        if (this == obj){
        	System.out.print(1);
           return true;
        }
        if (obj == null){
           	System.out.print(2);
           return false;
        }
        if (getClass() != obj.getClass()){
        	System.out.print(3);
           return false;
        }
        System.out.print(4);
        Trade other = (Trade) obj;

        if (this.ticker != other.ticker){
        	System.out.print(5);
           return false;
        }
        if (this.price != other.price){
        	System.out.print(6);  	
        	return false;
        }
        System.out.print(7);        
        return true;

     }
}

public class hashmap_linkedlist {

	public static void main(String[] args) {
		
	//	HashMap<String, List<Trade>> hm = new HashMap<String, List<Trade>>();
	
	/*    
	    myLinkedList mylist = new myLinkedList();
	    mylist.addNode(new Node("IBM",34);
	
	    Map<String, > map = new HashMap<>();
	    
	    map.put(101, new Trade("IBM", )
	    */
		HashMap<String, Trade> hm = new HashMap<String, Trade>();
		Trade td1 = new Trade("IBM",23);
		Trade td2 = new Trade("IBM",24);
		Trade td3 = new Trade("APPLE",25);
		/*
		 * Note that 'collision' generally refers to the internal working of the HashMap, 
		 * where two keys have the same hash value, not the use of the same key for 
		 * two different values.
		 * 
		 * in below case this is one key with two different values.
		 * this entry 24 overwrite 23 , that means my equal was not used.
		 */
		hm.put("IBM", td1);
		hm.put("IBM", td2);
		
		// if APPLE and IBM both return the same hashcode
		// then internal HashMap will build linkedlist for collisions.
		hm.put("APPLE", td3);
		Set<Map.Entry<String, Trade>> es = hm.entrySet();
		for (Map.Entry<String, Trade> i:es){
			System.out.println("entries "+i.getKey()+" "+i.getValue().ticker+" "+i.getValue().price);
		}
		
		// Bloomberg question has nothing to do with collision list
		// it wants to have a hashmap  with IBM as a key and value
		// is a linked list that keep most recent 10 trade values

		HashMap<String, LinkedList<Integer>> hml = new HashMap<String, LinkedList<Integer>>();
		
		LinkedList<Integer> li = new LinkedList<Integer>();
		li.addFirst(23);
		li.addFirst(24);
		hml.put("IBM", li);
		li.addFirst(25);
		li.addFirst(26);
		hml.put("IBM", li);		
		LinkedList<Integer> li2 = new LinkedList<Integer>();
		li2.addFirst(13);
		li2.addFirst(14);		
		hml.put("APPLE", li2);
		Set<Map.Entry<String, LinkedList<Integer>>> esl = hml.entrySet();
		for (Map.Entry<String, LinkedList<Integer>> i:esl){
			System.out.println("entries "+i.getKey());
			LinkedList<Integer> lst = i.getValue();
			if (lst.size() > 10)
				// track only first 10
				System.out.println(lst.subList(0,10)+" ");	
			else
				System.out.println(lst.subList(0,lst.size())+" ");
		}
		// we should also implement prune to only keep 10 items
		// to save memory.
	}
}
	

 