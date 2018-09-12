package com.mfy.link;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String ms[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<Character, String> map = new HashMap<Character, String>();
        for(int i=0;i<ms.length;i++){
        	char chr =(char) ('a'+i);
        	map.put(chr, ms[i]);
        }
        ArrayList<StringBuilder> arrayList = new ArrayList<StringBuilder>();
        for(String word:words){
        	char c[] = word.toCharArray();
        	StringBuilder sb = new StringBuilder();
        	for(char cc:c){
        		sb.append(map.get(cc));
        	}
        	arrayList.add(sb);
        }
        
        Set<String> set = new HashSet<String>();
        for(int j=0;j<arrayList.size();j++){
        	StringBuilder sBuilder = arrayList.get(j);
        	String string = sBuilder.toString();
        	System.out.println(string);
        	set.add(string);
        }
        return set.size();
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		String words[] = {"gin", "zen", "gig", "msg"};
		int ss =solution.uniqueMorseRepresentations(words);
		System.out.println(ss);
	}
}