package com.mfy.sort;

public class QuickSort<E extends Comparable<E>> {

	public void sort(E[] arr){
		quickSort(arr, 0, arr.length-1);
	}
	
	private void quickSort(E[] arr, int left, int right){
		if(left >= right)//为什么会有>,因为可能出现类似5、3、4的组合，partition之后p=right,之后使用quickSort(arr, p+1, right)就会出现>的情况。
			return;
		int p = partition(arr,left,right);
		quickSort(arr, left, p); 
		quickSort(arr, p+1, right);
	}

	private int partition(E[] arr, int left, int right) {
		E value = arr[left];
		int j = left;
		for(int i=left+1;i<=right;i++)
			if(arr[i].compareTo(value)<0)
				swap(i,++j,arr);
		swap(left, j, arr);
		return j;
	}

	private void swap(int i, int j, E[] arr) {
		if(i == j)
			return;
		E temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;	
	}
}
