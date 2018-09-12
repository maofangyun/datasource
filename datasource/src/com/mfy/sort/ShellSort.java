package com.mfy.sort;

public class ShellSort<E extends Comparable<E>> {
	
	public void sort(E[] arr){
		int section = arr.length/2;
		int j = 0;
		E temp;
		
		while(section>=1){
			for(int i=section;i<arr.length;i++){
				temp = arr[i];
				j = i-section;
				while(j>=0 && temp.compareTo(arr[j])<0){
					arr[j+section] = arr[j];
					j = j-section;
				}
				arr[j+section] = temp;
			}
			section /= 2;
		}
	}
}
