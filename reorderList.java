// Time Complexity : O(n)
// Space Complexity : O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }

        ListNode slow = findMid(head);
        ListNode fast = reverseList(slow.next);
        slow.next = null; // break the 2 lists
        slow = head; // reset to start of first list

        // rearrange nodes
        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }

    private ListNode findMid(ListNode slow) {
        ListNode fast = slow;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}