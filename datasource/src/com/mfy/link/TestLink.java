package com.mfy.link;


public class TestLink {
	
	private LinkNode<Integer> dummyHead = new LinkNode<Integer>();
	
	public LinkNode<Integer> CreateLink(int arr[]){
		LinkNode<Integer> head = dummyHead;
		for(int i=0;i<arr.length;i++){
			LinkNode<Integer> node = new LinkNode<Integer>(arr[i]);
			dummyHead.next = node;
			dummyHead = node;
		}
		return head;
	}
	
	public LinkNode<Integer> removeDupli(LinkNode<Integer> head,int val){
		if(head == null){
			return head;
		}
		if(head.e == val){
			LinkNode<Integer> ret = removeDupli(head.next, val);
			return ret;
		}
		else{
			LinkNode<Integer> ret = removeDupli(head.next, val);
			head.next =ret;//为什么要这句？ 因为前面可能有了一些目标元素，必须每次都进行更新。
			return head;
		}
//		if(head == null) return head;
//		LinkNode<Integer> ret = removeDupli(head.next, val);
//		head.next =ret;
//		return head.e == val?ret:head;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		TestLink testLink = new TestLink();
		int arr[] = {1,2,3,4,5,5,5,6,7,8};
		LinkNode head = testLink.CreateLink(arr);
		head = testLink.removeDupli(head.next, 5);
		LinkNode.toString(head);
//		leetcodeLinklist linklist = new leetcodeLinklist();
//		head = linklist.removeElements(head, 5);
//		LinkNode.toString(head);
		
	}
}
