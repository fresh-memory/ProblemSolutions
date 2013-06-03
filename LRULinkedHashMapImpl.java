/**
* If using hashmap + linkedlist, probably need to code double linked list by defining ListNode and prev, next pointers
* 
* Cannot use java's linked list not that convenient except supposing ls.remove(e) can be done in  O(1)
*
* LRU---------Least RECENTlY Used Cache!!!
* Not frequently... :-)*
/

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;




public class LRUCache<K,V> extends LinkedHashMap<K,V> {

	/**
	 * 
	 */
	
	//A special constructor is provided to create a linked hash map whose order of
	//iteration is the order in which its entries were last accessed, 
	//from least-recently accessed to most-recently (access-order).
	//This kind of map is well-suited to building LRU caches.
	//Sychronized Map
	//Map m = Collections.synchronizedMap(new LinkedHashMap(...));
	int capacity=0;
	
	LRUCache(int _size){
		super(_size, 1.1f, true);
		this.capacity=_size;

	}
	
	//must implement this one to limit the size of the cache
	protected boolean removeEldestEntry(Entry eldest)
	  {
	    return size() >capacity;
	  }
	/**
	* Clears the cache.
	*/
	public synchronized void clear() {
	   this.clear(); }

	/**
	* Returns the number of used entries in the cache.
	* @return the number of entries currently in the cache.
	*/
	public synchronized int usedEntries() {
	   return this.size(); }
	
	public static void main(String[] args){
		LRUCache<String, String> lrucache = new LRUCache<String, String>(3);
		lrucache.put("A", "1");
		lrucache.put("B", "1");
		lrucache.put("c", "1");
		lrucache.put("A", "1");
		lrucache.put("E", "1");
		lrucache.put("F", "1");
		
		Iterator<String> itr =lrucache.keySet().iterator();
		while(itr.hasNext()){
		System.out.println(itr.next());
	}}
}

