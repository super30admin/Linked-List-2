package s30Coding;

//Time Complexity :- O(n) :- since we iterate over all the nodes to find the middle node.
//Space Complexity :- O(1)

//LeetCode :- Yes
//Logic :- Find the middle element, reverse the second half and merge the two lists

public class ReorderLinkedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
		public void reorderList(ListNode head) {
		    if (head == null) return;

		    // find the middle of linked list
		    ListNode slow = head, fast = head;
		    while (fast != null && fast.next != null) {
		      slow = slow.next;
		      fast = fast.next.next;
		    }

		    // reverse the second part of the list
		    ListNode prev = null, curr = slow, tmp;
		    while (curr != null) {
		      tmp = curr.next;

		      curr.next = prev;
		      prev = curr;
		      curr = tmp;
		    }

		    // merge two sorted linked lists
		    ListNode first = head, second = prev;
		    while (second.next != null) {
		      tmp = first.next;
		      first.next = second;
		      first = tmp;

		      tmp = second.next;
		      second.next = first;
		      second = tmp;
		    }
		  }
}
