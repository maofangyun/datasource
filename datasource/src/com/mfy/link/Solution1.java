package com.mfy.link;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution1 {
	
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		//ArrayList<Integer> arr = new ArrayList<Integer>();
		int num[] = new int[5];
		for(int i:nums1)
			set1.add(i);
		for(int j:nums2)
			set2.add(j);
		Iterator<Integer> iterator = set2.iterator();
		int k=0;
		while(iterator.hasNext()){			
			int key = iterator.next();
			if(set1.contains(key)){
				num[k]=key;
			}
			k++;
		}
		return num;
    }
	
	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		int nums1[] = {1, 2, 2, 1};
		int nums2[] = {2, 2};
		int num[] = solution1.intersection(nums1, nums2);
		System.out.println(num[1]);
	}
}
