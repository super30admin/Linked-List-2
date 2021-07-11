// Time Complexity : O(n) -- length of the linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        ListNode temp = null;
        slow.next = null;
        while(fast != null){
            ListNode next = fast.next;
            fast.next = temp;
            temp = fast;
            fast = next;
        }
        fast=temp;
        ListNode next;
        while(head!=null && fast!=null){
            next=head.next;
            head.next=fast;
            fast=fast.next;
            (head.next).next=next;
            head=next;

       }
    }
}