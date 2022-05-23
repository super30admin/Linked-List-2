// Time Complexity : (n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class ReorderLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverseList(slow.next);
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
    private ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        ListNode temp1=head;
        ListNode temp2=head;
        while(temp1.next!=null){
            temp2=temp1.next;
            temp1.next=temp2.next;
            temp2.next=head;
            head=temp2;   
        }
        return head;
    }
}
