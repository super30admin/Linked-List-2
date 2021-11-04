// Time Complexity : O(1)
// Space Complexity : O(1)
// Any problem you faced while coding this : No

public class Delete_without_head {
    public void delete(ListNode del) {
    	if(del==null || del.next==null) {
    		return;
    	}
    	
    	del.val=del.next.val;
    	del.next=del.next.next;
    }
    
    public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
