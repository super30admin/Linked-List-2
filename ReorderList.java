// Time Complexity : O(n) .
// Space Complexity : O(1) no extra space used.
// Any problem you faced while coding this :


// We use floid to find middle, then we reverse next part of list after middle. Then we do:
// curr=slow.next;
// slow.next=fast;
// fast=fast.next;
// slow.next.next=curr;
// slow=curr;

//Success
//Details 
 // Runtime: 1 ms, faster than 99.82% of Java online submissions for Reorder List.
//  memory Usage: 42.2 MB, less than 6.82% of Java online submissions for Reorder List.

class Solution {
    public void reorderList(ListNode head) {
       //edge case
       if (head==null || head.next==null)return;
       //find middle 
	   ListNode slow=head;
	   ListNode fast=head;
	   while (fast.next!=null && fast.next.next!=null){
	     slow=slow.next;
	     fast=fast.next.next;
	   }
	   fast=reverserList(slow.next);//reverse rest of list after find the middle;
	   slow.next=null;
       slow=head;
	   ListNode curr;
	   while (fast!=null){
	     curr=slow.next;
	     slow.next=fast;
	     fast=fast.next;
	     slow.next.next=curr;
	     slow=curr;
	   }
    }
    
    private ListNode reverserList(ListNode node){
      ListNode prev=null;
      ListNode curr=node;
      ListNode fast=node.next;
      while (fast !=null){
        curr.next=prev;
	    prev=curr;
	    curr=fast;
	    fast=fast.next;
      }
      curr.next=prev;
      return curr;
    }
}