package com.coderscampus.assignment7unittesting;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	@Test
	void should_add_new_item_to_list() {
		
		CustomList<Integer> sut = new CustomArrayList<>();
		sut.add(10);
		sut.add(11);
		sut.add(12);
		sut.add(13);
		sut.add(14);
		sut.add(15);
		sut.add(16);
		sut.add(17);
		sut.add(18);
		sut.add(19);
		sut.add(20);
		
		Integer expectedResult = sut.get(0);

		// assertEquals(10, sut.get(0));
		assertEquals(10, expectedResult);
		assertEquals(20, sut.get(10));
		assertEquals(11, sut.getSize());
	}

	
	@Test
	void should_remove_item_to_list() {

		CustomList<Integer> sut = new CustomArrayList<>();
		sut.add(10);
		sut.add(11);
		sut.add(12);
		sut.add(13);
		sut.add(10);
		sut.add(11);
		sut.add(12);
		sut.add(13);
		sut.add(10);
		sut.add(11);
		sut.add(12);
		sut.add(6,66);
		
		Integer expectedResult1 = sut.remove(3);
		
		assertEquals(13, expectedResult1);
		assertEquals(11, sut.getSize());
	}

	
	@Test
	void should_add_item_at_index_to_list() {
		
		CustomList<Integer> sut = new CustomArrayList<>();

		sut.add(4,56);
		sut.add(6,66);
		
		assertEquals(56, sut.get(4));
		assertEquals(2, sut.getSize());
	}
}
