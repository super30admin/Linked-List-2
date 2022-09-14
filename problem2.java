//Problem2 - https://leetcode.com/problems/reorder-list/

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

public class problem2 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head;
       
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
           
        
        fast = reverse(slow);
        slow = head;
        
        ListNode temp;
        
        while(fast != null && slow != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
        
        
        private ListNode reverse(ListNode head){
            ListNode prev = null;
            ListNode next = null;
            ListNode curr = head;
            
            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
}
