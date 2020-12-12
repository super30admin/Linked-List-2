// Time - O(N)
// Space - O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null) {
            return head;
        }
        
        ListNode slow = head, fast = head;
        boolean hasCycle = false;
        while(fast.next != null && fast.next.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
               hasCycle = true; 
                break;
            }
        }
        
        if(!hasCycle) {
            return null;
        }
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
