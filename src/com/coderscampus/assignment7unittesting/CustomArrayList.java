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
		if(items.length == size) {
            items =	Arrays.copyOf(items, items.length * 2);		
		}
	}


	@Override
	public boolean add(int index, T item) {
       
		if ( isValidIndex(index)) {
			growArray();
			System.arraycopy(items, index, items, index+1, items.length - index - 1);
			items[index] = item;
			size++;
			return true;
		} else {
			System.out.println("Index out of bound");
			return false;
		}
	}
	
	public boolean isValidIndex(int index) {
		try {
			Objects.checkIndex(index, items.length);
		} catch (IndexOutOfBoundsException e) {
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
	public T get(int index) {
		return (T) items[index];
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
        Object element = items[index];
		System.arraycopy(items, index +1 , items, index, items.length -  index - 1);
		size--;	
		return (T) element;
	}
}
