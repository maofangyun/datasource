package com.mfy.sort;

public class InsertSort<E extends Comparable<E>>{
	
	public E[] sort(E[] arr){
		 for(int i=1;i<arr.length;i++){
			 E num = arr[i];
			 int j=i;
			 while(j>0){
				 if(arr[j-1].compareTo(num)>0){
					 arr[j] = arr[j-1];
				 }
				 else {
					break;
				}
				j--;
			 }
			 arr[j] = num;
		 }
		return arr;
	}
}
