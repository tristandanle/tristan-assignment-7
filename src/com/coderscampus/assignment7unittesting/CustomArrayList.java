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

	public boolean isValidIndex(int index) {
		try {
			Objects.checkIndex(index, size);

		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
			return false;
		}

		return true;
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {

		growArray();
		if (!(index > size)) {
			System.arraycopy(items, index, items, index + 1, items.length - index - 1);
			items[index] = item;
			size++;

		} else {

			throw new IndexOutOfBoundsException();
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

		Object elementIndex = new Object();

		if (isValidIndex(index)) {
			elementIndex = items[index];

		}

		return (T) elementIndex;

	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {

		if (isValidIndex(index)) {
			size--;
			System.arraycopy(items, index + 1, items, index, items.length - index - 1);
			items[size] = null;

		}

		return (T) items[index];
	}
}
