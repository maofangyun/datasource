package com.mfy.trie;

public class Test {
	public void fun(int k){
		System.out.println(k);
	}
	public static void main(String[] args) {
		Test test = new Test();
		int num = 0;
		for(int i=0; i<5; i++){
			test.fun(num+1);
		}
	}
}
