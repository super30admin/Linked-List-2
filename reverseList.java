package LinkedList2;

/* Time complexity : o(n) 
 * Space complexity : o(1)
Did this code run successfully in leetcode : yes
problems faces : no
*/

public class reverseList {
	
	public class ListNode{
		int val;
		ListNode next;
			ListNode(){}
			ListNode(int val){
				this.val = val;
			}
			ListNode(int val, ListNode next){
				this.val =val;
				this.next = next;
			}
	}
	
	public ListNode reverseList(ListNode head) {
		
		//base
		if(head == null || head.next == null) return head;
		
		ListNode prev = null;
		ListNode curr = head;
		ListNode fast = head.next;
		//logic
		
		while(fast!=null || fast.next != null) {
			curr.next = prev;
			prev = curr;
			curr = fast;
			fast = fast.next;
		}
		curr.next = prev;
		return curr;
	}
	

}
