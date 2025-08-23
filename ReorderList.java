// Time Complexity : O(n) where n is the number of nodes in the list
// Space Complexity : O(1) as we are rearranging the list in place without using extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// First, we split the LL into 2 halves at the middle. We reverse the second half of the LL inplace. Then we merge the two halves by alternating nodes from each half.

public class ReorderList {
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // find middle of the LL
        while (fast.next != null && fast.next.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the 2nd half
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        //merge 2 LL
        while (fast!=null) {
            ListNode tmp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = tmp;
            slow = tmp;
        }
        
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }
}
