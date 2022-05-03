package com.coderscampus.assignment7unittesting;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	@Test
	void should_add_new_item_to_list() {
		List<Integer> list = new ArrayList<>();
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
		
		sut.add(6,66);
		sut.add(7,77);
		
		Integer expectedResult1 = sut.remove(3);
		
		assertEquals(3, expectedResult1);
		assertEquals(11, sut.getSize());
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
		assertEquals(2, sut.getSize());
	}
}
