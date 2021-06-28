package LinkedList2;

/* Time complexity : o(L) - L is length untill nth node
 * Space complexity - o(1)
Did this code run successfully in leetcode : yes
problems faces : no
*/


 
class removeNthNodeFromEnd {
	 // Definition for singly-linked list.
	  public class ListNode {
	      int val;
	     ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	  
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int count = 0;
        
        while(count<=n){
            fast = fast.next;
            count++;
        }
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
