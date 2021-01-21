// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        //flip 2nd half of list
        //do this by finding mid and reverse from mid till end

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode dummy = slow;
        slow = slow.next;
        //take reversed array
        //reverse

        ListNode head2 = reverse(slow);
        dummy.next = null;
        ListNode head1 = head;
        ListNode next = head2.next;

        //merge with first half
        while(head2 != null){
            ListNode temp = head1.next;
            head1.next = head2;
            head2 = head2.next;
            head1.next.next = temp;
            head1 = temp;

        }

    }

    public ListNode reverse(ListNode curr){
        ListNode fast = curr.next;
        ListNode prev = null;

        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            if(fast != null){
                fast = fast.next;
            }
        }

        return prev;
    }
}