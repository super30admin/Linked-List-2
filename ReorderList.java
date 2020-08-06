// Time Complexity - O(3n) = O(n)
// Space Complexity - O(1)
// Approach: 
// We first find the mid of the LL, and reverse the mid +1 to n. 
// Secondly, merge the flipped array with 0 to mid to get the desired order.

class Solution {
    public void reorderList(ListNode head) {
        //edge
        if(head==null || head.next==null) return;
        ListNode slow=head, fast=head;
        //finding mid of linkedlist
        while(fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        fast = reverseList(slow.next);
        slow.next = null; // to get 2 lists
        slow = head;
        //merge two lists
        ListNode curr;
        while(fast!=null) {
            curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = curr.next;
        while(fast!=null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}