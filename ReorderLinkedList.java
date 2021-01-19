// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




import com.util.customlist.ListNode;

public class ReorderLinkedList {
	 public static void reorderList(ListNode head) {
	        if(head == null || head.next == null) return;
	        ListNode slow = head;
	        ListNode fast = head;
	        
	        while(fast.next != null && fast.next.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        fast = reverse(slow.next);
	        slow.next = null;
	        slow = head;
	        while(fast != null){
	            ListNode temp = slow.next;
	            slow.next = fast;
	            fast = fast.next;
	            slow.next.next = temp;
	            slow = temp;
	        }
	    }
	    
	    private static ListNode reverse(ListNode head){
	        ListNode prev = null;
	        ListNode curr = head;
	        ListNode fast = head.next;
	        while(fast != null){
	            curr.next = prev;
	            prev = curr;
	            curr = fast;
	            fast = fast.next;
	        }
	        curr.next = prev;
	        return curr;
	    }
	    
	    public static void main(String[] args) {
	    	ListNode one = new ListNode(1);
			ListNode two = new ListNode(2);
			ListNode three = new ListNode(3);
			ListNode four = new ListNode(4);
			ListNode five = new ListNode(5);
			one.next = two;
			two.next = three;
			three.next = four;
			four.next = five;
			
			ReorderLinkedList.reorderList(one);
			
		}
}
