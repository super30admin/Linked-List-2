// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class IntersectionNode {
    private ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode prev = null, current = head, fast = head.next;
        
        while(fast != null) {
            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;
        }
        
        current.next = prev;
        return current;
    }
    
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverseList(slow.next);

        slow.next = null;
        slow = head;
        ListNode temp = null;
        
        while(fast != null) {
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
}
