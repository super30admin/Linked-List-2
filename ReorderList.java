package LinkedList2;
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


import LinkedList1.ListNode;

// Your code here along with comments explaining your approach
class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast=fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode head){
        if(head == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = curr.next;
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