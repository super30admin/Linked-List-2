package Q_143._Reorder_List;

//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//You may not modify the values in the list's nodes, only nodes itself may be changed.
//
//Example 1:
//
//Given 1->2->3->4, reorder it to 1->4->2->3.
//Example 2:
//
//Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

//Time Complexity  : O(n)  
//Space Complexity : O(n)

public class Solution {

	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	 static ListNode root = new ListNode(1);
	
	
	 public void reorderList(ListNode head) {
		 
		 if(head == null || head.next == null) {
			 return;
		 }
		 
		 ListNode slow = head;
		 ListNode fast = head;
		 
		 
		 while(fast.next != null && fast.next.next != null) {
			 slow = slow.next;
			 fast = fast.next.next;
		 }
		 
		 fast = slow.next;
		 slow.next = null;
		 fast = reverseLinkedList(fast);
		 slow = head;
		 
		 ListNode temp= null;
//		 temp =slow;
		 
		 while(slow != null && fast != null) {
			temp = slow.next;
			slow.next = fast;
			fast = fast.next;
			slow.next.next = temp;
			slow = temp;
		 }
	    }
	 
	 public ListNode reverseLinkedList(ListNode head) {
		 ListNode prev = null;
		 ListNode curr = head;
		 ListNode next = head.next;
		 while(curr.next != null) {
			 curr.next = prev;
			 prev = curr;
			 curr = next;
			 next= next.next;
		 }
		 curr.next = prev;
		 return curr;
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);

		s.reorderList(root);
		
		System.out.print((root));
	}

}
