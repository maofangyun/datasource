package com.mfy.trie;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class MapSum {

    private class Node {
    	public boolean isWord;
    	public int count;
    	public Map<Character, Node> next;
    	
    	public Node(boolean end){
    		isWord = end;
    		count = 0;
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
    
    public MapSum() {
    	root = new Node();
    	size = 0;
    }
    
    public void insert(String key, int val) {
        insert(key, val,root);
        size++;
    }
    
    private void insert(String key, int val, Node node) {
		char ch[] = key.toCharArray();
		for(char c : ch){
			if(node.next.get(c) == null)
				node.next.put(c, new Node()); 
			node = node.next.get(c);
		}
		node.isWord = true;
		node.count = val;
	}

    public boolean contains(String word){
    	char ch[] = word.toCharArray();
    	Node cur = root;
    	for(char c : ch){
    		if(cur.next.get(c) == null)
    			return false;
    		cur = cur.next.get(c);
    	}
    	return true;
    }
    
	public int sum(String prefix) {
		char ch[] = prefix.toCharArray();
		if(!contains(prefix))
			return 0;
		Node node = getNode(ch, root);
		return sum(node);      
    }
	
	private int sum(Node node){
		int num = node.count;
		if(node.next.isEmpty())
			return node.count;
			
		for(char nextchar : node.next.keySet())
			num += sum(node.next.get(nextchar)); //核心语句		
		return num;
	}

	private Node getNode(char[] ch, Node node) {
		int index = 0;
		while(index != ch.length){
			node = node.next.get(ch[index]);
			index++;
		}
		return node;
	}
	
	public static void main(String[] args) {
		MapSum mapSum = new MapSum();
		mapSum.insert("apple", 3);
		mapSum.insert("app", 11);
		mapSum.insert("application", 7);
		System.out.println(mapSum.sum("appl"));
	}
}
