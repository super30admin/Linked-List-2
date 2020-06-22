// Time Complexity :O(n) n is the number of nodes in the linked list
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null) return;
        
        //find mid
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //separate them and reverse
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        //merge them
        ListNode curr;
        while(fast!=null){
            curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
       
    }
    
    private ListNode reverse(ListNode head){
        ListNode curr = head; ListNode prev =null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}