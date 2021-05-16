import java.util.*;
class Person{
	String name;
	List<Person> parents;
	List<Person> child;
	
	Person(String name){
		this.name = name;
		parents = new ArrayList<Person>();
		child = new ArrayList<Person>();
	}
	
	void addParent(Person parent) {
		parents.add(parent);
	}
	
	void addChild(Person child) {
		this.child.add(child);
	}
}


public class FamilyTree {
	
	List<String> getFamilyTreeFromPerson(Person A) {
		List<String> tree= new ArrayList<String>();
		Queue<Person> master = new LinkedList<Person>();
		Map<String,Boolean> visited = new HashMap<>();
		
		master.add(A);
		while(!master.isEmpty()) {
			Person temp = master.poll();
			tree.add(temp.name);
			visited.put(temp.name, true);
			for(int i=0;i<temp.child.size();i++) {
				if(visited.get(temp.child.get(i).name)!=null) continue;
				master.add(temp.child.get(i));
			}
			
		}
		
		return tree;
	}
	
	Stack<String> getFamilyTreeToPerson(Person A) {
		Stack<String> tree= new Stack<String>();
		Queue<Person> master = new LinkedList<Person>();
		Map<String,Boolean> visited = new HashMap<>();
		
		master.add(A);
		while(!master.isEmpty()) {
			Person temp = master.poll();
			tree.push(temp.name);
			visited.put(temp.name, true);
			for(int i=0;i<temp.parents.size();i++) {
				if(visited.get(temp.parents.get(i).name)!=null) continue;
				master.add(temp.parents.get(i));
			}
			
		}
		
		return tree;
	}
	
	public static void main(String[] args) {
		Person a = new Person("A");
		Person b = new Person("B");
		Person c = new Person("C");
		Person d = new Person("D");
		Person z = new Person("Z");
		
		a.addChild(c);
		c.addParent(a);
		
		a.addChild(d);
		d.addParent(a);
		
		b.addChild(c);
		c.addParent(b);
		
		b.addChild(d);
		d.addParent(b);
		
		z.addChild(a);
		a.addParent(z);
		
		FamilyTree tree = new FamilyTree();
		
		System.out.println(tree.getFamilyTreeFromPerson(a));
		System.out.println(tree.getFamilyTreeToPerson(a));
		System.out.println();
		System.out.println(tree.getFamilyTreeFromPerson(b));
		System.out.println(tree.getFamilyTreeToPerson(b));
		System.out.println();
		System.out.println(tree.getFamilyTreeFromPerson(c));
		System.out.println(tree.getFamilyTreeToPerson(c));
		System.out.println();
		System.out.println(tree.getFamilyTreeFromPerson(d));
		System.out.println(tree.getFamilyTreeToPerson(d));
		System.out.println();
		System.out.println(tree.getFamilyTreeFromPerson(z));
		System.out.println(tree.getFamilyTreeToPerson(z));
	}
	
	
}
