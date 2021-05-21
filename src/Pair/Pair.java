package Pair;

import java.io.Serializable;

public class Pair<T,E> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	T first;
	E second;
	
	public Pair() {
		
	}
	
	public Pair(T first, E second) {
		this.first = first;
		this.second = second;
	}

	public void setValue(T first, E second) {
		this.first = first;
		this.second = second;
	}
	
	public Pair<T,E> getValue() {
		return this;
	}
	
	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public E getSecond() {
		return second;
	}

	public void setSecond(E second) {
		this.second = second;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair<T,E> other = (Pair<T,E>) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}
	
	public static <T,E> Pair<T,E> with(T first, E second) {
		return new Pair<T,E>(first, second);
	}
	
	
	

}
