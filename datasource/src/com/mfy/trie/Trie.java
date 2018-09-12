package com.mfy.trie;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Trie {
	private class Node {
		public Map<Character, Node> next;
		boolean isWord;
		
		public Node(boolean end) {
			isWord = end;
			next = new HashMap<Character, Node>();
		}
		
		public Node(){
			this(false);
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Set set = next.keySet();
			Iterator it = set.iterator();
			while(it.hasNext()){
				sb.append(it.next());
			}
			return sb.toString();
		}
	}
	
	private Node root;
	private int size;
	
	public Trie(){
		root = new Node();
		size = 0;
	}
	
	public void add(String word){
		add(word, root);
		size++;
	}
	
	private void add(String word, Node node){
		char ch[] = word.toCharArray();
		for(char c : ch){
			if(node.next.get(c) == null)
				node.next.put(c, new Node());
			node = node.next.get(c);			
		}
		node.isWord = true;
	}
	
	public boolean isPrefix(String prefix){
		char ch[] = prefix.toCharArray();
		Node cur = root;
		for(char c : ch){
			if(cur.next.get(c) == null)
				return false;
			cur = cur.next.get(c);
		}
		return true;
	}
	
	public void delete(String word){
		char ch[] = word.toCharArray();
		delete(ch,ch.length,root,0);
		size--;
	}

	private Node delete(char[] ch, int total, Node node, int index) {
		if(index == total){
			node.isWord = false;
			//System.out.println(node);
			return node;
		}
		char c = ch[index];
		if(node == null)
			throw new IllegalArgumentException("no such word");
		Node ret = delete(ch, total, node.next.get(c), index+1);
		if(ret.next.size() == 0 && !ret.isWord){
			node.next.remove(c);
		}
		//System.out.println(node);
		return node;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("apple");
		trie.add("app");
		trie.add("public");
		trie.add("find");
		trie.delete("find");
		trie.delete("app");
		System.out.println(trie.isPrefix("ap"));
		System.out.println(trie.isPrefix("fi"));
	}
}
