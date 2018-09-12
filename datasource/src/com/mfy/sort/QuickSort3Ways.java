package com.mfy.sort;

import java.util.Random;

public class QuickSort3Ways<E extends Comparable<E>> {
	
	public void sort(E[] arr){
		sort(arr,0,arr.length-1);
	}

	private void sort(E[] arr, int left, int right) {	
		if(left >= right)
			return;
		//分治
		int location = new Random().nextInt(10000)%(right-left+1)+left;
		swap(left,location,arr);
		E value = arr[left];
		int lt = left;
		int gt = right+1;
		int index = left+1;
		
		while(index < gt){
			if(arr[index].compareTo(value)>0){
				swap(index, --gt, arr);
			}
			else if (arr[index].compareTo(value)<0) {
				swap(++lt, index, arr);
				index++;
			}
			else {
				index++;
			}
		}
		swap(left, lt, arr);		
		sort(arr, left, lt);
		sort(arr, gt, right);
	}
	
	private void swap(int i, int j, E[] arr) {
		if(i == j)
			return;
		E temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;	
	}
}
