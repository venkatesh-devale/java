package com.venkatesh;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGenericsDemo {

	@Test
	public void test() {
		GenericsDemo<Integer> gInt = new GenericsDemo<>();
		//adding integer
		assertEquals(true, gInt.addT(1)); // this shows the green output in JUnit	
	}

}
