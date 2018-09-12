package com.mfy.link;

public class LinkNode<T> {
	public T e;
	public LinkNode<T> next;
	
	public LinkNode(T node, LinkNode<T> next) {
		this.e = node;
		this.next = next;
	}
	
	public LinkNode(T node){
		this.e = node;
		this.next = null;
	}
	
	public LinkNode(){
		this.e = null;
		this.next = null;
	}
	
	public static void toString(LinkNode node){
		while(node != null){
			System.out.print(node.e+"-->");
			node = node.next;
		}
		System.out.print("NULL");
	}
}
