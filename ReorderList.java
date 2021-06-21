// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Traverse to the mid of the list using 2 pointers
// Reverse the second half of the list
// Reorder the list by pointing to the nodes accordingly
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        
        ListNode first = head;
        ListNode slow = head;
        ListNode prev = null;

        
        while(first!=null && first.next!=null ) {
            first= first.next.next;
            slow = slow.next;
        }
        
        first = head;
        slow = reverseList(slow);
        
        while (slow.next != null) {
            ListNode temp = first.next;
            first.next = slow;
            first = temp;
            
            temp = slow.next;
            slow.next = first;
            slow = temp;
        }
     
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next==null)
            return head;
        
        ListNode reversedHead = reverseList(head.next);
        head.next.next = head;
        head.next  = null;
        
        return reversedHead;
    }
}