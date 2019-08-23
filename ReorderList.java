package LinkedLists;

public class ReorderList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		reorderList(head);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
/**
 * Time: O(n)
 * Space: O(1)
 * Leetcode accepted: yes
 * Problems faced: no
 */
	private static void reorderList(ListNode head) {
		 if(head == null || head.next == null) return;
		//Find the middle node in linkedlist
		ListNode slow = head, fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;
		
		//Reverse the second part of the linkedlist
		ListNode prev = null;
		while(head2 != null) {
			ListNode next = head2.next;
			head2.next = prev;
			prev = head2;
			head2 = next;
		}
		head2 = prev;
		
		//Combine both lists
		while(head != null && head2 != null) {
			ListNode temp = head.next;
			head.next = head2;
			head2 = head2.next;
			head.next.next = temp;
			head = head.next.next;
		}
	}

}
