package com.mfy.sort;

public class MergeSort<E extends Comparable<E>> {
	
	
	private static int result = 0;

	public void sort(E[] arr, int left, int right){
		if(left>=right)
			return;
		int mid = (right-left)/2+left;
		sort(arr, left, mid);
		sort(arr, mid+1, right);
		if(arr[mid].compareTo(arr[mid+1])>0)
			merge(arr, left, mid, right);
	}
	
	public int reversePairs(E[] arr) {
        sort(arr, 0, arr.length - 1);
        return result;
    }
	
	@SuppressWarnings("unchecked")
	private void merge(E[] arr, int left, int mid, int right){
		Object[] temp = new Object[right-left+1];
		for(int m=left;m<=right;m++)
			temp[m-left] = arr[m];
		int i=left, j=mid+1;
		for(int k=left;k<=right;k++){
			if(i>mid){
				arr[k] = (E) temp[j-left];
				j++;
			}
			else if (j>right) {
				arr[k] = (E) temp[i-left];
				i++;
			}
			else if(((E) temp[i-left]).compareTo((E) temp[j-left])<0){ //这里错了，不能用arr
				arr[k] = (E) temp[i-left];
				i++;
			}				
			else {
				arr[k] = (E) temp[j-left];
				result += (mid-i+1);
//				求逆序对的核心代码,为什么是mid-i？ 是因为i代表的数组和j代表的数组都是有序的数组，只要i数组有一个元素大于j数组中某一个元素，则
//				i数组之后所有的元素都会大于此元素，所以是mid-1。
				j++;
			}
		}
	}
}
