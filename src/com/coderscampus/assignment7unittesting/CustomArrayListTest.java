package com.coderscampus.assignment7unittesting;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	@Test
	void should_add_new_item_to_list() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for ( int i = 0; i < 10 ; i ++   ) {
			sut.add(i);
		}
		sut.add(2,2000);
		sut.add(3,3000);
		
		Integer expectedResult = sut.get(0);

		// assertEquals(10, sut.get(0));
		assertEquals(0, expectedResult);
		assertEquals(2000, sut.get(2));
		assertEquals(12, sut.getSize());
	}

	
	@Test
	void should_remove_item_to_list() {
		
		CustomList<Integer> sut = new CustomArrayList<>();
		for ( int i = 0; i < 10 ; i ++   ) {
			sut.add(i);
		}
		
		sut.remove(9);
		sut.remove(5);
		sut.add(9,1000);
		sut.add(2,2000);
		sut.add(3,3000);
		//sut.remove(45);
		Integer expectedResult = sut.get(0);
		
		assertEquals(0, expectedResult);
                assertEquals(2000, sut.get(2));
       	        assertEquals(11, sut.getSize());
		// Index out of bound
		//sut.add(34,87);
	}

	
	@Test
	void should_add_item_at_index_to_list() {
		
		CustomList<Integer> sut = new CustomArrayList<>();

		for ( int i = 0; i < 10 ; i ++   ) {
			sut.add(i);
		}
		
		sut.add(4,56);
		sut.add(6,66);
		
		assertEquals(56, sut.get(4));
		assertEquals(12, sut.getSize());
		// sut.add(86,66);
	}
}
