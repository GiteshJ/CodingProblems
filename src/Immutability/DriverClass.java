package Immutability;

import java.util.ArrayList;
import java.util.List;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address address = new Address("London", "511101");

        List<String> phone = new ArrayList<>();
        phone.add("1234");
        phone.add("4321");

        Student student = new Student("Frodo Baggins",phone, address);

        System.out.println("Student street: " + student.getAddress().getStreet());
        System.out.println("Student pincode: " + student.getAddress().getPincode());
        System.out.println("Student phone: " + student.getPhone());

        Address studentAddress = student.getAddress();
        studentAddress.setStreet("Canada");
        studentAddress.setPincode("611101");

        List<String> studentPhone = student.getPhone();
        studentPhone.remove("1234");
        studentPhone.remove("4321");
        
        System.out.println();
        System.out.println("Immutability has been hacked!");
        System.out.println();

        System.out.println("Student street: " + student.getAddress().getStreet());
        System.out.println("Student pincode: " + student.getAddress().getPincode());
        System.out.println("Student phone: " + student.getPhone());
    }

}
