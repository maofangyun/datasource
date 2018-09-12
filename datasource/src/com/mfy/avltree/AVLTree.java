package com.mfy.avltree;

import java.util.ArrayList;
import java.util.Random;

public class AVLTree<K extends Comparable<K>,V>{
	private class Node {
		public K key;
		@SuppressWarnings("unused")
		public V value;
		public Node left;
		public Node right;
		public int height;
		
		public Node(K key ,V value){
			this.key = key;
			this.value = value;
			left = null;
			right = null;
			height = 1;
		}		
	}
	
	private Node root;
	private int size;
	
	public AVLTree(){
		root = null;
		size = 0;
	}
	
	public int getsize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int getHeight(Node node){
		if(node == null)
			return 0;
		//return Math.max(getHeight(node.left), getHeight(node.right))+1;
		return node.height;
	}
	
	public int getBalanceFactor(Node node){
		if(node == null)
			return 0;
		return getHeight(node.left) - getHeight(node.right);
	}
	
	public boolean isBalance(Node node){
		if(node == null)
			return true;
		if(Math.abs(getBalanceFactor(node))>1)
			return false;
		return isBalance(node.left) && isBalance(node.right);
	}
	
	public boolean isBST(){
		ArrayList<K> keys = new ArrayList<K>();
		inOrder(root,keys);
		for(int i=1; i<keys.size(); i++){
			if(keys.get(i).compareTo(keys.get(i-1))<0)
				return false;
		}
		return true;
	}
	
	private void inOrder(Node node, ArrayList<K> keys) {
		if(node == null)
			return;
		inOrder(node.left, keys);
		keys.add(node.key);
		inOrder(node.right, keys);
	}

	public void add(K key ,V value){
		root = add(root,key,value);
		size++;
	}

	private Node add(Node node, K key, V value) {
		if(node == null)
			return new Node(key, value);
		if(key.compareTo(node.key)<0)
			node.left = add(node.left, key, value);
		else if(key.compareTo(node.key)>0)
			node.right = add(node.right, key, value);
		else 
			node.value = value;
		//缺了更新height的语句。
		int balanceFactor = getBalanceFactor(node);
		if(balanceFactor >1 && getBalanceFactor(node.left)>=0)
			node = rightRorate(node);
		if(balanceFactor <-1 && getBalanceFactor(node.right)<0)
			node = leftRorate(node);
		if(balanceFactor >1 && getBalanceFactor(node.left)<0){
			node.left = leftRorate(node.left);
			node = rightRorate(node);
		}
		if(balanceFactor <-1 && getBalanceFactor(node.right)>=0){
			node.right = rightRorate(node.right);
			node = leftRorate(node);
		}			
		return node;
	}

	private Node rightRorate(Node node) {
		Node y = node.left;
		Node T = y.right;
		y.right = node;
		node.left = T;
		
		node.height = Math.max(T.height, node.right.height)+1;
		y.height = Math.max(node.height, y.left.height)+1;
		
		return y;
	}
	
	private Node leftRorate(Node node) {
		Node y = node.right;
		Node T = y.left;
		y.left = node;
		node.right = T;
		
		node.height = Math.max(T.height, node.left.height)+1;
		y.height = Math.max(node.height, y.right.height)+1;
		
		return y;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AVLTree<Integer, Integer> avlTree = new AVLTree<Integer, Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int k =0 ; k<1000 ; k++){
			int e = new Random().nextInt(10000);
			arr.add(e);
		}
		for(int num : arr){
			avlTree.add(num, null);
		}
		boolean is = avlTree.isBST();
		boolean balance = avlTree.isBalance(avlTree.root);
		System.out.println(balance);
	}
}
