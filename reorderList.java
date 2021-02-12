// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
            
        if (head == null) return;
        
        // find middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        
        //reverse second half
        ListNode prev = null;
        ListNode curr = slow;
        ListNode temp;
        while(curr!=null) {
            
            temp = curr.next;
            curr.next = prev;
            prev=curr;
            curr=temp;
        }
        slow.next=null;
        slow=curr;
        
        // Combine two lists into order required
        ListNode first = head, second = prev;
        while (second.next != null) {
        
            temp = second;
            second=second.next;
            temp.next = first.next;
            first.next = temp;            
            first = temp.next;
        }
        
    }
}
