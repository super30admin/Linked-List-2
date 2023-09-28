// Time Complexity : O(n) traverses through all nodes of list
// Space Complexity : O(1) not using any additional space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {

    public void reorderList(ListNode head) {

        if(head == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = reversedList(slow.next);

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

    private ListNode reversedList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

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
