/*
Approach
Use slow/fast pointers to find the middle, then reverse the second half of the linked list.
Merge the first half and reversed second half alternately: L0 → Ln → L1 → Ln-1 ....
Modify only the next pointers, so no node values are changed.

Time Complexity: O(n)
Space Complexity: O(1)
*/
class ReorderListProblem {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;

        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        // prev is the head of the reversed second half
        second = prev;

        // Step 3: Merge the two halves
        ListNode first = head;

        while (second != null) {

            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}

