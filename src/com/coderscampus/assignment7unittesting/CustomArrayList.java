package com.coderscampus.assignment7unittesting;

import java.util.Arrays;
import java.util.Objects;

public class CustomArrayList<T> implements CustomList<T> {

	private static final int MIN_CAPACITY = 10;
	Object[] items = new Object[MIN_CAPACITY];
	int size = 0;

	@Override
	public boolean add(T item) {

		growArray();
		items[size++] = item;
		return true;
	}

	public void growArray() {
		if (items.length == size) {
			items = Arrays.copyOf(items, items.length * 2);
		}
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		System.arraycopy(items, index, items, index + 1, items.length - index - 1);
		items[index] = item;
		size++;
		growArray();
		if (items[items.length - 1] != null) {
			items[size - 1] = item;
			items[items.length - 1] = null;
		}

		return true;

	}

	public boolean isValidIndex(int index) {
		try {
			Objects.checkIndex(index, items.length);

		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Illegal capacity: " + index);
		}
		
		return (T) items[index];
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if (isValidIndex(index)) {
			System.arraycopy(items, index + 1, items, index, items.length - index - 1);
			items = Arrays.copyOf(items, items.length - 1);
			size--;
			items = Arrays.copyOf(items, items.length + 1);
			return (T) items[index];
		} else {
			
			return null;
		}
	}
}
