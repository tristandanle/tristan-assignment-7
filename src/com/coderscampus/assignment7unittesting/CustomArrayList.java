package com.coderscampus.assignment7unittesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomArrayList<T> implements CustomList<T> {

	private static final int MIN_CAPACITY = 10;
	Object[] items = new Object[MIN_CAPACITY];
	// int i = 0;
	int size = 0;
	Integer element = 0;

	@Override
	public boolean add(T item) {

		if (items[size] == null || item != null) {
			items[size++] = item;
			return true;
		}
		return false;
	}

	@Override
	public boolean add(int index, T item) {
		Object newArray[] = new Object[items.length + 1];
		boolean added = false;
		if (index < 0 || index > items.length) {
			throw new IndexOutOfBoundsException("Index out of bounds" + index);
		} else {

			// copy elements of old array to new array
			for (int i = 0; i < items.length; i++) {
				newArray[i] = items[i];
			}
			// insert item to a specific index in newArray
			newArray[index] = item;

			// shuffle to the right
			for (int i = index + 1; i <= items.length; i++) {
				newArray[i] = items[i - 1];
			}

			// increase size to the old array items
			items = new Object[newArray.length];

			// copy elements of new array back to old array
			for (int c = 0; c < items.length; c++) {
				items[c] = newArray[c];
				added = true;
				// System.out.println(items[c]);
			}
			// increment 1 when an element is added every time
			size++;
		}
		return added;
	}

	@Override
	public int getSize() {
		// System.out.println(items.length);
		return size;
	}

	@Override
	public T get(int index) {
		return (T) items[index];// (Integer) Arrays.asList(items).indexOf(index);
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {

		try {
			for (int i = 0; i < items.length; i++) {
				if (i == index) {
					element = (Integer) items[index];
					for (int j = i; j < items.length - 1; j++) {
						items[j] = items[i + 1];
					}
					break;
				}

			}

		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		size--;
		return (T) element;
	}
}
