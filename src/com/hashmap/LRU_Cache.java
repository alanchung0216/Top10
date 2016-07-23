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
 
How would you build one? First, let's be clear: get and set should
 be O(1).While building an LRU cache requires that you think in 
 terms of 2 data structures, the reality is that these two data 
 structures actually work more or less separately from each other.

First, we'll need a hashtable. This'll be the structure we use to 
quickly get and set objects. Next, we'll need a doubly linked list. 
Whenever we get or set an item from the cache, we'll put (or promote) 
that same object to the front of our list. When we need to free memory, 
we'll trim the tail of our list and remove it from our hashtable.

Namely, we have a hashtable (the items map) and a linked list 
(the list). The cache's capacity along with the Cacheable's Size 
are used together to track available memory 

Set's implementation isn't too difficult either:
The first thing we do is make sure we have enough space in our cache 
for the new object. If not, we need to free up some memory. 
Once we know we have enough memory, we can either update the
 existing entry or create a new one. Either way, we make sure 
 that the item is promoted or pushed to the front of our list. 
 There's a small bug in the above implementation. When we're 
 replacing an item, we really should take its original size into 
 consideration when figuring out if we have enough capacity 
 (for example, if we are replacing a 10MB item with a 2MB item, 
 we're sure to have enough space). Implementing that would just 
 make Set unnecessarily complex for this example though.

The final piece of the puzzle is the prune method:

Exactly what you decide to prune is really going to be app-specific. 
Here we decided to just prune the oldest 50 items. Crude, but it works. 
Pruning involves removing the tail item from our list, removing that 
item form our hashtable, and finally recording the freed capacity. 
The .(*LRUCacheItem) syntax is how you cast in Go.

To be of any use, our cache is missing one fundamental part: 
concurrency control. As a bad start, you could control access to 
Get and Set through a mutex. However, more fine-grained locking 
through a read-write mutex is a more suitable solution. Our own 
cache has 2 layers (more or less a hashtable of hashtables), 
which means that the few write lock on the main cache are short lived.

Depending on your specific needs, there are a lot of customizations 
you can make. In our case, we know that our system has spare memory, 
so we can take a number of shortcuts. For example, we don't promote 
an item that's been recently promoted. This means that, in a lot 
of cases, we've replaced a write-lock with a read-lock.


 */
public class LRU_Cache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
