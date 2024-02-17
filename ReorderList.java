// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Find mid of the list; reverse the second list; then interlink them

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // finding the middle at slow; list2 will be slow.next
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // list2: needs to be reversed
        fast = slow.next;
        // list 1
        slow.next = null;

        ListNode prev = null;
        ListNode next;

        while (fast != null) {
            next = fast.next;
            fast.next = prev;
            prev = fast;
            fast = next;
        }

        // list 2 has been reversed and the head is at prev
        fast = prev;
        // list 1 which was severed at slow earlier
        slow = head;

        ListNode temp1;
        ListNode temp2;
        // interlinking slow and fast now (l1 and reversed l2)
        while (fast != null) {
            temp1 = slow.next;
            temp2 = fast.next;
            slow.next = fast;
            fast.next = temp1;
            slow = temp1;
            fast = temp2;
        }
    }
}