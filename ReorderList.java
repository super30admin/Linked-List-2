// Time Complexity : O(n), n is number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//find mid
// reverse mid+1 to n
//keep pointer at start of first half and reverse of 2nd half
//merge these two alternatively

class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null) return; 
        
        ListNode slow = head;
        ListNode fast = head;
        
        //FIND MIDDLE
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next; 
        }
        
        //REVERSE
        
        //reverse mid+1 to last node
        //fast points to first node of reversed list
        fast = reverse(slow.next);
        
        //point slow.next to null, last nodes next is null
        //then point slow to first node
        slow.next = null; 
        slow = head; 
        
        
        // REARRAGEMENT / REORDER
        
        //to get reference of next node in 1st half of the list
        ListNode curr = slow.next;
        
        //if odd no. of nodes, fast will point to null first
        //if even no. of nodes, slow and fast will point to null
        while(fast.next != null) {
            //to connect (L0 -> Ln) ..
            slow.next = fast; 
            //to not lose reference of Ln-1, so fast = fast.next (we wont lose reference of fast)
            //as slow.next = fast
            fast = fast.next;
            // slow.next.next ~~ fast.next (Ln -> L1)
            slow.next.next = curr;
            //move slow to curr
            slow = curr; 
            curr = curr.next; 
        }
        //to rearrage last 3 nodes
        //to avoid null pointer exception
        slow.next = fast;
        fast.next = curr; 
    
    }
    
    //REVERSE Method from mid+1 to last node (o/p : last node ------ mid+1)
    private ListNode reverse (ListNode rhead) {
        ListNode prev = null;
        ListNode curr = rhead.next;
        
        while(curr != null) {
            rhead.next = prev;
            prev = rhead;
            rhead = curr;
            curr = curr.next;   
        }
        rhead.next = prev; 
        
        //points to (last node of original list) (first of reverse)
        return rhead; 
        
    }
}


