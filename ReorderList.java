// Time Complexity : O(n)
// Space Complexity : O(1) — in-place
// Did this code successfully run on LeetCode : Yes

// approach:
// 1) Find middle with fast/slow; cut list into two halves.
// 2) Reverse the second half.
// 3) Merge first and reversed-second halves by alternating nodes.


public class ReorderList {
    public ListNode getMiddle(ListNode head){
        ListNode hare = head;
        ListNode turtle = head;

        while(hare.next != null && hare.next.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void reorderList(ListNode head){
        if(head == null || head.next == null){
            return;
        }

        ListNode middle = getMiddle(head);
        ListNode secondHalfStart = reverse(middle.next);
        middle.next = null;

        ListNode firstHalfStart = head;
        while(firstHalfStart != null && secondHalfStart != null){
            ListNode temp1 = firstHalfStart.next;
            ListNode temp2 = secondHalfStart.next;

            firstHalfStart.next = secondHalfStart;
            secondHalfStart.next = temp1;

            firstHalfStart = temp1;
            secondHalfStart = temp2;
        }
    }
}
