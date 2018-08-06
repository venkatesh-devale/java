package com.venkatesh;
import java.util.ArrayList;
import java.util.Iterator;

public class GenericsDemo<T> {
	private ArrayList<T> arrayList;
	
	public GenericsDemo() {
		arrayList = new ArrayList<T>();
	}
	
	public boolean addT(T temp) {
		return arrayList.add(temp);
	}
	
	public void printList() {
		Iterator<T> it = arrayList.iterator();
		while(it.hasNext()) 
			System.out.println("The list is:"+it.next());
	}
	
}
