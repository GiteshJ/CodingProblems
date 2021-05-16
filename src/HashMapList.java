import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapList<T,E> {

	private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();
	
	public void put(T key, E item) {
		if(!map.containsKey(key)) map.put(key, new ArrayList<E>());
		map.get(key).add(item);
	}
	
	public void put(T key, ArrayList<E> items) {
		map.put(key, items);
	}
	
	public ArrayList<E> get(T key){
		return map.get(key);
	}
	
	public boolean containsKey(T key) {
		
		return map.containsKey(key);
	}
	
	public boolean containsKeyValue(T key, E value) {
		
		ArrayList<E> items = map.get(key);
		if(items==null) return false;
		return items.contains(value);
	}
	
	public Set<T> getKeys(){
		return map.keySet();
	}
	
	@Override
	public String toString() {
		return map.toString();
	}
}
