// Time Complexity : O(n) = n/2 to get middle, n/2 to reverse half list, n to reorder
// Space Complexity : O (1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : remember how to figure out the null cases, 
// when getting middle of list consider even and odd length lists,
// in the reordering part, understand how to get the null case as fast != null,
// depending on which list is larger

public class prob3 {
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }

    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        // get the mid next for reversal
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // get reversed 2nd half
        fast = getReversedList(slow.next);
        slow.next = null;
        slow = head;
        ListNode temp = null;
        // merge the lists
        while(fast != null){ // if odd list, 1st half (slow) has one less node
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

        
    }

    public ListNode getReversedList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode fast = head.next;
        while (fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }

    
}
    

