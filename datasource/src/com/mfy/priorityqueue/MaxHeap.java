package com.mfy.priorityqueue;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap <E extends Comparable<E>>{
	
	private List<E> array;
	
	public MaxHeap(){
		array = new ArrayList<E>();
	}
	
	public MaxHeap(E[] data){
		//待补充，传入数组，组成最大堆。
		array = new ArrayList<E>();
		for(E e:data)
			array.add(e);
		for(int i = parent(array.size()-1);i>=0;i--)
			shiftDown(i);
	}
	
	public int size(){
		return array.size();
	}
	
	public boolean isEmpty(){
		return array.isEmpty();
	}
	
	public E findMax(){
		return array.get(0);
	}
	
	public boolean contain(E e){
		return array.contains(e);
	}
	
	public int parent(int index){
		if(index == 0|| index < 0 || index > array.size())
			throw new IllegalArgumentException("out of bound");
		return (index-1)/2;
	}
	
	public int leftChild(int index){
		if(index < 0 || index > array.size())
			throw new IllegalArgumentException("out of bound");
		return 2*index+1;
	}
	
	public int rightChild(int index){
		if(index < 0 || index > array.size())
			throw new IllegalArgumentException("out of bound");
		return 2*index+2;
	}
	
	public void add(E e){
		array.add(e);
		shiftUP(array.size()-1);
	}
	
	public E extractMax(){
		E max = findMax();
		array.set(0, array.get(array.size()-1));
		array.set(array.size()-1, null);
		shiftDown(0);
		return max;
	}
	
	private void shiftUP(int index){
		int parent = parent(index);
		while(array.get(index).compareTo(array.get(parent))>0){
			swap(index,parent);
			index = parent;
			if(index == 0)
				break;
		}
	}
	
	private void shiftDown(int index){
		while(leftChild(index)<array.size()){
			int k = leftChild(index);
			E left = array.get(k);
			E right = array.get(k+1);
			if(k+1 < array.size() && left.compareTo(right)<0){
				k++;
			}
			swap(index,k);
			index = k;
		}
	}

	private void swap(int index, int parent) {
		E temp = array.get(index);
		array.set(index, array.get(parent));
		array.set(parent, temp);
	}
	
	
}
