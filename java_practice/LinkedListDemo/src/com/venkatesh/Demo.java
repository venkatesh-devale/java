package com.venkatesh;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		LinkedList<String> placesToVisit = new LinkedList<String>();
		addInOrder(placesToVisit, "Sangli");
		addInOrder(placesToVisit, "Pune");
		addInOrder(placesToVisit, "Kolhapur");
		addInOrder(placesToVisit, "Kolhapur");
		addInOrder(placesToVisit, "Satara");
		printList(placesToVisit);
		visit(placesToVisit);
		
	}
	
	public static void printList(LinkedList<String> list) {
		Iterator<String> i = list.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println("=============");
	}
	
	private static boolean addInOrder(LinkedList<String> linkedlist, String newCity) {
		ListIterator<String> stringListIterator = linkedlist.listIterator();
		while(stringListIterator.hasNext()) {
			int comparison = stringListIterator.next().compareTo(newCity);
			if(comparison == 0) {
				System.out.println(newCity+" is already included as destination");
				return false;
			} else if(comparison > 0) {
				stringListIterator.previous();
				stringListIterator.add(newCity);
				return true;
			} else if(comparison < 0){
				
				
			}
			
		
			
		}
		stringListIterator.add(newCity);
		return true;
	}
	
	private static void visit(LinkedList<String> cities) {
		boolean quit = false;
		boolean goingForward = true;
		ListIterator<String> listIterator = cities.listIterator();
		Scanner scanner = new Scanner(System.in);
		if(cities.isEmpty()) {
			System.out.println("No iternary planned");
			return;
		} else {
			System.out.println("The iternary starts with "+listIterator.next());
			printMenu();
		}
		while(!quit) {
			System.out.println("Enter your choice:");
			int answer =scanner.nextInt();
			scanner.nextLine();
			switch(answer) {
			case 0:
				System.out.println("Vacation over!");
				quit = true;
				break;
			
			case 1:
				if(!goingForward) {
					if(listIterator.hasNext())
						listIterator.next();
				}
				goingForward = true;
				if(listIterator.hasNext()) {
					System.out.println("Now visiting "+listIterator.next());
				} else {
					System.out.println("We have reached the end of the cities");
					goingForward = false;
				}
				break;
			
			case 2:
				if(goingForward) {
					if(listIterator.hasPrevious()) 
						listIterator.previous();
				}
				goingForward = false;
				if(listIterator.hasPrevious()) {
					System.out.println("Now visting "+listIterator.previous());
				} else{
					System.out.println("We are at the first city");
					goingForward = true;
				}
				break;
				
			case 3:
				printMenu();
				break;
			}
		}
	}
	
	private static void printMenu() {
		System.out.println("Available choices:\n");
		System.out.println("0 - quit\n"
				+ "1 - Visit Next City\n"
				+ "2 - Visit Previous City\n"
				+ "3 - Print Menu again");
	}
}
