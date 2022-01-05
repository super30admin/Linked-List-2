






public class DelWithoutHead {

	public class ListNode {
	      int val;
	     ListNode next;
 ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	    }
	
	void deleteNode(ListNode del)
	   {
	        del.val = del.next.val;
	        del.next = del.next.next;
	   }
}
