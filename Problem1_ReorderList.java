// Time Complexity : o(N)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        
        if (head == null || head.next == null || head.next.next == null)
            return;
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode prev=null;
        ListNode curr;
       /* // for odd list
        if(fast!=null)
        {
            curr=slow.next;
        }
        else
        {
            // for even list
            curr=slow;
        }
        */
        
        curr=slow.next;
        ListNode next=null;
        slow.next=null;  // cut the first part
        
        // reversing from slow the second part
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
       
        while(prev!=null)
        {
            ListNode headTemp=head.next;
            ListNode prevTemp=prev.next;
            
            head.next=prev;
            prev.next=headTemp;
            
            head=headTemp;
            prev=prevTemp;
        }
    }
}