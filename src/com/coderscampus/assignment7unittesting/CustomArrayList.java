package com.coderscampus.assignment7unittesting;

import java.util.Arrays;
import java.util.Objects;

public class CustomArrayList<T> implements CustomList<T> {

	private static final int MIN_CAPACITY = 10;
	Object[] items = new Object[MIN_CAPACITY];
	int size = 0;
	Integer element = 0;

	@Override
	public boolean add(T item) {
   
		growArray();
		items[size++] = item;
		return true;
	}


	public void growArray() {
		if(items.length == size) {
            items =	Arrays.copyOf(items, items.length + 1);		
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
			System.out.println("Index out of bounds");
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
		// System.out.println(items.length);
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		return (T) items[index];// (Integer) Arrays.asList(items).indexOf(index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
        Object element = items[index];
		items = Arrays.copyOf(items, items.length - 1);		
		System.arraycopy(items, index +1 , items, index, items.length -  index - 1);
		size--;	
		return (T) element;
	}
}
