package com.mfy.link;

public class leetcodeLinklist {
	
//	 private class ListNode {
//	     int val;
//	     ListNode next;
//	     ListNode(int x) { val = x; }
//	 }
	 
	 public LinkNode removeElements(LinkNode<Integer> head, int val) {
		if(head == null)
			return head;
		LinkNode retLinkNode = removeElements(head.next, val);
		head.next = retLinkNode;
		return head.e == val? retLinkNode :head;
	 }
}
