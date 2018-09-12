package com.mfy.sort;

import java.util.Random;

public class TestSort {
	
	public Integer[] build(int rangeL, int rangeR, int size){
		int range = rangeR - rangeL;
		Integer arr[] = new Integer[size];
		for(int i=0; i<size; i++){
			arr[i] = new Random().nextInt(range)+rangeL;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		TestSort testSort = new TestSort();
		Integer arr[] = testSort.build(0, 10000, 20);
//		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();
//		arr = selectionSort.sort(arr);
//		InsertSort<Integer> insertSort = new InsertSort<Integer>();
//		arr = insertSort.sort(arr);
//		MergeSort<Integer> mergeSort = new MergeSort<Integer>();
//		mergeSort.sort(arr, 0, arr.length-1);
//		ShellSort<Integer> shellSort = new ShellSort<Integer>();
//		shellSort.sort(arr);
//		QuickSort<Integer> quickSort = new QuickSort<Integer>();
//		quickSort.sort(arr);
//		QuickSort3Ways<Integer> quickSort3Ways = new QuickSort3Ways<Integer>();
//		quickSort3Ways.sort(arr);
		MaxK<Integer> maxK = new MaxK<Integer>();
		System.out.println(maxK.maxK(arr, 5));
		QuickSort3Ways<Integer> quickSort3Ways = new QuickSort3Ways<Integer>();
		quickSort3Ways.sort(arr);
		for(int i : arr){
			System.out.print(i+" ");
		}
	}
}
