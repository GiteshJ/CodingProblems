package Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DriverClass {
	HashMap<Integer,Integer> map = new HashMap<>();
	public static class Test{
		
		int val;
		
		public Test(int val) {
			this.val = val;
		}
		public String show() {
			return "I am Test Object with Val = " + val;
		}
	}
	
	public static void main(String[] args) {
		
		Pair<Integer,Integer> pair1 = new Pair<>();
		pair1.setFirst(12);
		pair1.setSecond(67676);
		System.out.println(" First : " + pair1.getFirst() + " Second : " + pair1.getSecond());
		
		Pair<Integer,Test> pair2 = new Pair<>();
		pair2.setFirst(12);
		pair2.setSecond(new Test(44));
		System.out.println(" First : " + pair2.getFirst() + " Second : " + pair2.getSecond().show());
		
		Pair<Test,Test> pair3 = new Pair<Test,Test>();
		pair3.setFirst(new Test(2));
		pair3.setSecond(new Test(3));
		System.out.println(" First : " + pair3.getFirst().show() + " Second : " + pair3.getSecond().show());
		
		Pair<Test,List<Test>> pair4 = new Pair<Test,List<Test>>();
		pair4.setFirst(new Test(4));
		pair4.setSecond(new ArrayList<Test>());
		pair4.getSecond().add(new Test(5));
		pair4.getSecond().add(new Test(6));
		System.out.print(" First : " + pair4.getFirst().show() + " Second : ");
		pair4.getSecond().stream().forEach(data -> System.out.print(data.show() + "   "));
		
		Pair<Integer,Integer> pair5 = new Pair<>();
		pair5.setFirst(12);
		pair5.setSecond(67676);
		System.out.println(" First : " + pair5.getFirst() + " Second : " + pair5.getSecond());
		
		System.out.println(pair1.equals(pair5));
	}

}
