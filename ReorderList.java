// Time Complexity : O(n), O(n) to find mid, O(n) to reverse the 2nd half, O(n) to link in crisscross way 
// Space Complexity : O(1), just need additional pointers at each step
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : idea has been taken from class

// Your code here along with comments explaining your approach
// Idea is to chop the linked list in half
// reverse the 2nd half
// now join both halves in a criss cross way

class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = reverse(slow.next);
        slow.next = null;
        
        ListNode head1 = head;
        ListNode temp1, temp2;
        
        while(head2!=null){
            temp1 = head1.next;
            head1.next = head2;
            
            temp2 = head2.next;
            head2.next = temp1;
            
            head1 = temp1;
            head2 = temp2;
        }
    }
    
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        
        ListNode temp;
        ListNode p1=head, p2=head.next;
        head.next = null;
        
        while(p2!=null){
            temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        
        return p1;
    }
}