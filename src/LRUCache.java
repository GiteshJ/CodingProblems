import java.util.HashMap;

public class LRUCache {
	
	private int maxCacheSize;
	private HashMap<Integer, LinkedListNode> map = new HashMap<>();
	private LinkedListNode listHead;
	public LinkedListNode listTail;
	
	public LRUCache(int maxSize) {
		maxCacheSize = maxSize;
	}
	
	private static class LinkedListNode{
		
		private LinkedListNode prev,next;
		public int key;
		public String value;
		public LinkedListNode(int key, String value){
			this.key = key;
			this.value = value;
			
		}
		
	}

	public String getValue(int key) {
		LinkedListNode item = map.get(key);
		
		if(item==null) return null;
		
		if(item!=listHead) {
			removeFromLinkedList(item);
			insertAtFrontOfLinkedList(item);
		}
		System.out.println(" Value : " + item.value);
		return item.value;
		
	}
	
	private void removeFromLinkedList(LinkedListNode node) {
		if(node==null) return;
		if(node.prev!=null) node.prev.next = node.next;
		if(node.next!=null) node.next.prev = node.prev;
		if(node == listTail) listTail = node.prev;
		if(node == listHead) listHead = node.next;
	}
	
	private void insertAtFrontOfLinkedList(LinkedListNode node) {
		if(listHead == null) {
			listHead = node;
			listTail = node;
			
		}
		else {
			listHead.prev  = node;
			node.next = listHead;
			listHead = node;
		}
	}
	
	public boolean removeKey(int key) {
		
		LinkedListNode node = map.get(key);
		removeFromLinkedList(node);
		map.remove(key);
		if(node != null) System.out.println(" Removing Key : " + key);
		return true;
		
	}
	
	
	public void setKeyValuePair(int key, String value) {
		removeKey(key);
		
		if(map.size()>= maxCacheSize && listTail!=null) {
			removeKey(listTail.key);
		}
		
		LinkedListNode node = new LinkedListNode(key,value);
		insertAtFrontOfLinkedList(node);
		map.put(key, node);
	}
	
	public void viewCache() {
		LinkedListNode temp  = listHead;
		while(temp!=null) {
			System.out.println(" Key : " + temp.key + " || Value : " + temp.value);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		
		int maxSize = 4;
		LRUCache cache = new LRUCache(maxSize);
		
		cache.setKeyValuePair(1, "A");
		cache.setKeyValuePair(2, "B");
		cache.setKeyValuePair(3, "C");
		cache.setKeyValuePair(4, "D");
		
		cache.viewCache();
		
		cache.getValue(3);
		
		cache.setKeyValuePair(5, "E");
		cache.viewCache();
		
		cache.getValue(4);
		cache.viewCache();
		cache.setKeyValuePair(6, "F");
		cache.setKeyValuePair(7, "G");
		cache.viewCache();
		
		
		
	}
	
}
