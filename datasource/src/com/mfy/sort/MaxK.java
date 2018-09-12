package com.mfy.sort;

import java.util.Random;

//有问题，求最大K值不稳定，有时候是K-1，有时候是K，原因未知。
public class MaxK<E extends Comparable<E>> {
	
	public E maxK(E[] arr, int k){
		return sort(arr,0,arr.length-1,k-1);
	}

	private E sort(E[] arr, int left, int right, int k) {	
		if(left >= right)
			return null;
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
		if(lt > k)
			return sort(arr, left, lt, k);
		else if (gt < k)
			return sort(arr, gt, right, k);
		else {
			return value;
		}		
	}
	
	private void swap(int i, int j, E[] arr) {
		if(i == j)
			return;
		E temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;	
	}
}
