// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * 1. Find mid of linked list using slow and fast pointer.
 * 2. split list to two lists at middle.
 * 3. reverse second list.
 * 4. merge the lists to make reordered list
 */
public class ReorderList {

	public void reorderList(ListNode head) {
		
		ListNode slowp=head;
		ListNode fastp=head;
		
		while(fastp.next!=null && fastp.next.next!=null) {
			slowp=slowp.next;
			fastp=fastp.next.next;
		}
		
		//now slowp at mid of the list
		//divide list to two lists
		
		fastp=slowp.next;
		slowp.next = null;
		
		
		//now reverse second part of the array
		slowp=head;
		fastp = reverse(fastp);
		
		while(fastp!=null) {
			ListNode temp=slowp.next;
			slowp.next=fastp;
			fastp=fastp.next;
			slowp.next.next=temp;
			slowp=temp;
		}	
		
	}
	
	private ListNode reverse(ListNode head) {
		ListNode prev=null;
		ListNode current= head;
		while(current!=null) {
			ListNode temp= current.next;
			current.next=prev;
			prev=current;
			current=temp;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		ListNode head= new ListNode(1);
		head.next= new ListNode(2);
		head.next.next= new ListNode(3);
		head.next.next.next= new ListNode(4);
		head.next.next.next.next= new ListNode(5);
		head.next.next.next.next.next= new ListNode(6);
		head.next.next.next.next.next.next= new ListNode(7);
		new ReorderList().reorderList(head);
	}
	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
