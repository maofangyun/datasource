package com.mfy.mytree;

import java.util.LinkedList;
import java.util.Queue;


public class BST <E extends Comparable<E>>{
	
	private class TreeNode {
		public E e;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(E e) {
			this.e = e;
		}
	}
	
	private TreeNode root;
	private int size;
	
	public BST(){
		root = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	//添加节点
	public TreeNode add(E e){
		root = add(root,e);
		return root;
	}

	private TreeNode add(TreeNode node, E e) {
		if(node == null)
			return new TreeNode(e);
		if(e.compareTo(node.e)<0)
			node.left = add(node.left,e);
		if(e.compareTo(node.e)>0)
			node.right = add(node.right,e);
		size++;
		return node;
	}
	
	public boolean contains(E e){
		return contains(root,e);
	}

	private boolean contains(TreeNode node, E e) {
		boolean bool = false;
		if(node == null)
			return false;
		if(node.e == e)
			return true;	
		if(e.compareTo(node.e)<0)
			bool = contains(node.left,e);
		if(e.compareTo(node.e)>0)
			bool = contains(node.right,e);
		return bool;
	}
	
	public void preOrder(){
		preOrder(root);
	}

	private void preOrder(TreeNode node) {
		if(node == null)
			return;
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void inOrder(){
		inOrder(root);
	}

	private void inOrder(TreeNode node) {
		if(node == null)
			return;		
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}
	
	public void postOrder(){
		postOrder(root);
	}

	private void postOrder(TreeNode node) {
		if(node == null)
			return;		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}
	
	public void levelOrder(){
		levelOrder(root);
	}

	private void levelOrder(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		while(!queue.isEmpty()){
			TreeNode level = queue.remove();
			System.out.println(level.e);
			if(level.left != null)
				queue.add(level.left);
			if(level.right != null)
				queue.add(level.right);
		}
	}
	
	public E minimum() throws Exception{
		if(size == 0)
			throw new Exception("tree为空");
		return minimum(root).e;
	}

	private TreeNode minimum(TreeNode node) {
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
	
	public E removeMin() throws Exception{
		root = removeMin(root);
		return minimum();
	}
	
	private TreeNode removeMin(TreeNode node){
		if(node.left == null)
			return node.right;
		node.left = removeMin(node.left);
		size--;
		return node;
	}
	
	public TreeNode remove(E e){
		root = remove(root,e);
		return root;
	}

	private TreeNode remove(TreeNode node, E e) {
		if(node == null)
			return null;
		if(e.compareTo(node.e)<0)
			node.left = remove(node.left,e);
		else if(e.compareTo(node.e)>0)
			node.right = remove(node.right,e);
		else{
			if(node.left == null){
				TreeNode rightNode = node.right;
				node.right =null;
				size--;
				return rightNode;
			}
			if(node.right == null){
				TreeNode leftNode = node.left;
				node.left =null;
				size--;
				return leftNode;	
			}
			TreeNode successor = minimum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			return successor;
		}
		return node;
	}
	
  @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(TreeNode node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
    
    public static void main(String[] args) throws Exception {
		int arr[] = {8,3,5,7,1,9};
		BST<Integer> bst = new BST<Integer>();
		for(int i :arr){
			bst.add(i);
		}
		
		bst.levelOrder();
	}
}
