// TC: O(N) where n is number of nodes in list
// SC: O(1) because of constant space.

// We are traversing till the middle of the list and reversing the second half of the Linked List. So, we have 2 parts in one list, one correct order and another half of list
// reversed. We assign first pointer next to the second pointer and second pointer next to the first pointer next. Similarly we keep iterating over the entire list
// until we reach end of second list since it represents end of list.

public class ReOrderList {

	public void Reorder(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast!=null && fast.next!=null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode prev = null;
		ListNode curr = slow;
		
		while(curr!=null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;					
		}
		
		ListNode first = head;
		ListNode second = prev;
		
		while(second.next!=null) {
			ListNode temp = first.next;
			first.next = second;
			first = temp;
			
			temp = second.next;
			second.next = first;
			second = temp;
		}
		
	}
	
	public static void main(String[] args) {
		
		ReOrderList rll = new ReOrderList();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		rll.Reorder(head);
		
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
		
	}
}
