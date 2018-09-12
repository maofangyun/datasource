package com.mfy.leetcode;

public class AddTwoNumbers {
	 private class ListNode {
		    int val;
		    ListNode next;
		    ListNode(int x) { val = x; }
		 }
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int num1 = reverse(l1, -1);
    	int num2 = reverse(l2, -1);
    	int num = num1+num2;
    	int i = 0;
    	int res[] = new int[3];
    	while(num>0){
    		res[i] = num%10;
    		num /= 10;
    		i++;
    	} 
    	return build(res).next;
    }
    
	private int reverse(ListNode listNode, int index){
    	if(listNode.next == null){
    		return (int) (listNode.val*Math.pow(10, index));
    	}    		
    	int num = reverse(listNode.next,index+1);
    	return (int) (listNode.val*Math.pow(10, index)+num);
    }
	
	public ListNode build(int[] num){
		ListNode node = new ListNode(0);
		ListNode head = node;
		for(int i=0; i<num.length; i++){
			node.next = new ListNode(num[i]);
			node = node.next;
		}
		return head;
	}
	  
	public static void main(String[] args) {
		AddTwoNumbers sum = new AddTwoNumbers();
		int num1[] = {2,4,3};
		int num2[] = {5,6,4};
		ListNode list1 = sum.build(num1);
		ListNode list2 = sum.build(num2);
		ListNode res = sum.addTwoNumbers(list1, list2);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
	}
}
