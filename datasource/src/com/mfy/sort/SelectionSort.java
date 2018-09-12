package com.mfy.sort;

public class SelectionSort<E extends Comparable<E>> {
	
	public E[] sort(E[] arr){
		for(int i=0;i<arr.length-1;i++){
			int index = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[index].compareTo(arr[j])>0)
					index = j;
			}
			swap(i,index,arr);
		}
		return arr;
	}

	private void swap(int i, int index, E[] arr) {
		E temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}
}
