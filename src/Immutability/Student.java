package Immutability;

import java.util.ArrayList;
import java.util.List;

/*
 * @refer - https://medium.com/@n0rdy/immutable-classes-in-java-76635df0356d
 * 
 * 
 * Let’s summarize out steps:
 * 1. removing setters;
 * 2. adding all args constructor;
 * 3. marking the class as final to protect it from being extended;
 * 4. initializing all non-primitive mutable fields via constructor by performing a deep copy;
 * 5. performing cloning of the returned non-primitive mutable object in getter methods;
 * 6. marking all class fields as final (optional step).
 */
public final class Student {

		
	public final String name;
	public final List<String> phone;
	public final Address address;
	
	public Student(String name, List<String> phone, Address address) {
		this.name = name;
		this.phone = new ArrayList<>(phone);
		this.address = new Address(address.getStreet(), address.getPincode());
	}
	
	public String getName() {
		return name;
	}
	
	public List<String> getPhone() {
		return new ArrayList<>(phone);
	}
	
	public Address getAddress() {
		return new Address(address.getStreet(), address.getPincode());
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
			Student other = (Student) obj;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (phone == null) {
				if (other.phone != null)
					return false;
			} else if (!phone.equals(other.phone))
				return false;
			return true;
		}
}
