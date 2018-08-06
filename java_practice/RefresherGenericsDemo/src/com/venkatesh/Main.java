package com.venkatesh;

public class Main {

	public static void main(String[] args) {
		//Creating first the class with Integers
		GenericsDemo<Integer> gInt = new GenericsDemo<>();
		//adding integers
		gInt.addT(1);
		gInt.addT(2);
		gInt.addT(3);
		
		//Creating first the class with Strings
		GenericsDemo<String> gString = new GenericsDemo<>();
		//adding strings
		gString.addT("Venkatesh");
		gString.addT("Kshitija");
		gString.addT("Kaustubh");
		
		//printing list of Integers:
		gInt.printList();
		
		//printing list of Integers:
		gString.printList();
		
		
		
	}

}
