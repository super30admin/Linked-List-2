package Q_160_Intersection_of_Two_Linked_Lists;
//Write a program to find the node at which the intersection of two singly linked lists begins.
//
//For example, the following two linked lists:
//
//
//begin to intersect at node c1.
//
// 
//
//Example 1:
//
//
//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//Output: Reference of the node with value = 8
//Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). 
//From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. 
//There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
// 
//
//Example 2:
//
//
//Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
//Output: Reference of the node with value = 2
//Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). 
//From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the 
//intersected node in A; There are 1 node before the intersected node in B.


//Time Complexity  : O(n)  
//Space Complexity : O(1)



public class Solution {
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }

	static ListNode root = new ListNode(0);
	static ListNode root1 = new ListNode(10);

	
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		 int lenA = 0 ,lenB = 0;
		 if(headA == null || headB == null ) {
			 return null;
		 }
		 
		 ListNode temp = headA;
		 while(temp.next != null) {
			 temp = temp.next;
			 lenA++;
		 }
		 temp = headB;
		 while(temp.next != null) {
			 temp = temp.next;
			 lenB++;
		 }
		 
		 if(lenA > lenB) {
			 while(lenA > lenB) {
				 headA = headA.next;
				 lenA--;
			 }
		 }else {
			 while(lenB > lenA) {
				 headB = headB.next;
				 lenB--;
			 }
		 }
		 
		 while(headA != headB) {
			 if(headA == null || headB == null) {
				 return null;
			 }
			 headA = headA.next;
			 headB = headB.next;
		 }
		
		 
		 
		 
	     return headA;   
	    }
	public static void main(String[] args) {

		root.next = new ListNode(1);
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(3);
		root.next.next.next.next = new ListNode(4);
		
		root1.next = new ListNode(9);
		root1.next.next = new ListNode(8);
		root1.next.next.next = root.next.next;
		
		Solution s = new Solution();
		System.out.println(s.getIntersectionNode(root, root1).val);
	}

}
