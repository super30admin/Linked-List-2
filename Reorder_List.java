// Time Complexity : O(3n) = O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*First find the middle element by using two pointers.
 * Reverse the second half of the list and merging the two lists in an alternating manner.*/

public class Reorder_List {
	public void reorderList(ListNode head) {
		if(head == null || head.next == null)
			return;

		// two pointers to find the middle
		ListNode slow = head; 
		ListNode fast = head;

		while(fast.next != null && fast.next.next != null){ // for even and odd lists
			slow = slow.next;
			fast = fast.next.next;
		}

		// reversal, reversing from mid next and pointing fast to it
		fast = reverse(slow.next);

		slow.next = null;   // break the link between two lists
		slow = head;    //reset slow to start of list

		//merging the two lists
		ListNode curr;

		while(fast != null){
			curr = slow.next;   // curr to point slow.next so that we dont loose the link
			slow.next = fast;
			fast = fast.next;
			slow.next.next = curr;
			slow = curr;           
		}
	}

	private ListNode reverse(ListNode head){
		ListNode prev = null;
		ListNode curr = head;
		ListNode fast = head.next;

		while(fast != null){
			curr.next = prev;
			prev = curr;
			curr = fast;
			fast = fast.next;
		}
		curr.next = prev;   //last element to reverse
		return curr;
	}
}
