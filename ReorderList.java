// Time Complexity is O(n) --> for the reverse, mid and merge
// Space Complexity is O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation


// Find the middle of the list using fast and slow pointers.
// Reverse the second half of the list.
// Merge the two halves alternately in-place.

class Solution {
    public void ReorderList(ListNode head) {
        if (head == null || head.next == null) return;

        //Find the mid

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //point the fast to the second reversed list 
        fast = reverse(slow.next);

        //break the first list last node connection
        slow.next = null;

        slow = head;
        // create the new rordered list
        while(fast!=null){
            ListNode temp  = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;

    }
}
