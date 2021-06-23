// Time Complexity : O(n)), 
// Space Complexity : O(1),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package linkedList2;

public class ReorderLinkedList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        //first find middle of the list
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the list after the middle
        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;
        //merge both list
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
     public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}
