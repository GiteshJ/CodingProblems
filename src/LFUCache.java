import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;


public class LFUCache {

	
	HashMap<Integer,String> data;
	HashMap<Integer,Integer> counter;
	HashMap<Integer, LinkedHashSet<Integer>> cacheList;
	int cacheSize;
	int min;
	
	public LFUCache(int maxSize) {
		data = new HashMap<>();
		counter = new HashMap<>();
		cacheList = new HashMap<>();
		min = -1;
		cacheSize = maxSize;
		cacheList.put(1, new LinkedHashSet<>());
		
	} 
	
	public String getValue(Integer key) {
		
		if(!data.containsKey(key)) return null;
		
		int count = counter.get(key);
		counter.put(key, count+1);
		cacheList.get(count).remove(key);
		
		if(count==min && cacheList.get(count).size()==0) min++;
		
		if(!cacheList.containsKey(count+1))
			cacheList.put(count+1, new LinkedHashSet<>());
		cacheList.get(count+1).add(key);
		System.out.println(" Value : " + data.get(key));
		return data.get(key);
	}
	
	public void setKeyValuePair(Integer key, String value) {
		
		if(data.containsKey(key)) {
			data.put(key, value);
			getValue(key);
			return;
		}
		if(data.size() >= cacheSize) {
			int evictKey = cacheList.get(min).iterator().next();
			data.remove(evictKey);
			counter.remove(evictKey);
			cacheList.get(min).remove(evictKey);
		}
		
		data.put(key, value);
		min = 1;
		counter.put(key, min);
		cacheList.get(min).add(key);
		
	}
	
	public void viewCache() {
		
		for(Integer keys : cacheList.keySet()) {
			Iterator<Integer> itr = cacheList.get(keys).iterator();
			while(itr.hasNext())
				{
					int showKey = itr.next();
					System.out.println(" Key : " + showKey + 
							" || Value : " + data.get(showKey) +
							" || Frequency : " + counter.get(showKey));
				}
						
		}
	}
	
	public static void main(String[] args) {
		
		int maxSize = 4;
		LFUCache cache = new LFUCache(maxSize);
		
		cache.setKeyValuePair(1, "A");
		cache.setKeyValuePair(2, "B");
		cache.setKeyValuePair(3, "C");
		cache.setKeyValuePair(4, "D");
		cache.viewCache();
		
		cache.getValue(1);
		cache.getValue(4);
		cache.getValue(3);
		cache.setKeyValuePair(5, "E");
		cache.viewCache();
		
		cache.getValue(5);
		cache.getValue(4);
		cache.viewCache();
		
		cache.setKeyValuePair(6, "F");
		cache.getValue(6);
		cache.getValue(6);
		cache.getValue(6);
		cache.viewCache();
		
		cache.setKeyValuePair(7, "G");
		cache.viewCache();
		
		
		
	}
}
