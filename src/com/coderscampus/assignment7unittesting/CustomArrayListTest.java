package com.coderscampus.assignment7unittesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	/*** Test-Driven Development Methodology ***/
	// Step 1 - Write a failing test
	// Step 2 - Write the business logic to make the test pass
	// step 3 - refactor your code

	@Test
	void should_add_new_item_to_list() {
		// Three A's
		// Arrange, Act, Assert

		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();

		// Act
		sut.add(10);
		sut.add(11);
		Integer expectedResult = sut.get(0);
		Integer expectedSize = sut.getSize();

		// Assert

		// assertEquals(10, sut.get(0));
		assertEquals(10, expectedResult);
		assertEquals(11, sut.get(1));
		assertEquals(2, sut.getSize());

	}

	@Test
	void should_remove_item_to_list() {

		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();

		// Act

		sut.add(10);
		sut.add(11);
		sut.add(12);
		sut.add(13);
		Integer expectedResult1 = sut.remove(3);

		// Assert
		assertEquals(13, expectedResult1);

	}

	@Test
	void should_add_item_at_index_to_list() {

		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();

		// Act
		sut.add(10);
		sut.add(11);
		sut.add(12);
		sut.add(13);
		sut.add(14);
		sut.add(15);
		sut.add(2, 22);

		Integer expectedSize = sut.getSize();
		// Assert
		assertEquals(22, sut.get(2));
		assertEquals(7, expectedSize);

	}

}
