package com.mfy.priorityqueue;

public class MyPriorityQueue<E extends Comparable<E>> {
	
	private MaxHeap<E> maxHeap;
	
    public MyPriorityQueue(){
        maxHeap = new MaxHeap<>();
    }
    
    public int size(){
    	return maxHeap.size();
    }
    
    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }
    
    public E getFront(){
    	return maxHeap.findMax();
    }
    
    public void enqueue(E e){
    	maxHeap.add(e);
    }
    
    public E dequeue(){
    	return maxHeap.extractMax();
    }
}
