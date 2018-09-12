package com.mfy.trie;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class WordDictionary {
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
	
    /** Initialize your data structure here. */
    public WordDictionary() {
		root = new Node();
		size = 0;
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	return search(word.toCharArray(), root, 0);
    }
    
    public boolean search(char ch[], Node node, int index){
    	if(index == ch.length)
    		return node.isWord;
    	if(node == null)
    		return false;
    	char c = ch[index];
    	if(c == '.'){
    		for(char nextchar : node.next.keySet()){
    			if(search(ch, node.next.get(nextchar), index+1))
    				return true;
    			}
    		return false;
    	}
    	else{
    		node = node.next.get(c);
    		return search(ch, node, index+1);
    	}
    }
}
