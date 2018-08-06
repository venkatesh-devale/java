package com.venkat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] locker_array = new boolean[100];
		//keeping all lockers closed at first
		for(int i = 0; i < locker_array.length; i++)
			locker_array[i] = false;
		
		//traversing array starting with student's number
		for(int i = 0; i < locker_array.length; i++) {
			for(int j = i; j < locker_array.length; j = j + i + 1) {
				
				if(locker_array[j] == false) {
					locker_array[j] = true;
				} else {
					locker_array[j] = false;
				}
			}
		}
		
		System.out.println("Printing all open lockers:");
		for(int i = 0; i < locker_array.length; i++) {
			if(locker_array[i] == true) 
				System.out.println((i + 1)+" ");
		}
	}

}
