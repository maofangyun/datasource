package com.mfy.leetcode;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
    	int count = nums.length;
    	int ret[] = new int[2];
    	for(int i=0; i<count; i++){
    		for(int j=i+1; j<count; j++){
    			if(nums[i]+nums[j] == target){
    				ret[0] = i;
    				ret[1] = j;
    				return ret;
    			}
    		}
    	}
		return null;
    }
    
    public static void main(String[] args) {
		TwoSum tt = new TwoSum();
		int nums[] = {2, 7, 11, 15};
		int show[] = tt.twoSum(nums, 9);
		System.out.println(show[0]+" "+show[1]);
	}
}
