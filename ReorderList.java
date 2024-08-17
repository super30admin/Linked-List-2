// Problem 143. Reorder List
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second half
        fast = reverseList(slow.next);
        // 4->5 , make it null 4 points to null
        slow.next = null;
        // merge two halves
        slow = head;
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            // next node
            ListNode next = current.next;
            // reverse pointer
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
