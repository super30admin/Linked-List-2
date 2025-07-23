//Time Complexity: O(n) — traverses the list 3 times: to find the middle, reverse the second half, and merge.
//Space Complexity: O(1) — in-place manipulation without using extra space.

//Use slow and fast pointers to find the middle of the linked list.
//Reverse the second half of the list starting from the middle.
//Merge the first half and reversed second half alternately to reorder the list.

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        ListNode secondHalfReversed = reverseList(slowPointer.next);
        slowPointer.next = null;

        ListNode firstHalfPointer = head;
        ListNode secondHalfPointer = secondHalfReversed;

        while (secondHalfPointer != null) {
            ListNode tempNext = firstHalfPointer.next;
            firstHalfPointer.next = secondHalfPointer;
            secondHalfPointer = secondHalfPointer.next;
            firstHalfPointer.next.next = tempNext;
            firstHalfPointer = tempNext;
        }
    }

    private ListNode reverseList(ListNode node) {
        ListNode previous = null;
        ListNode current = node;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;
    }
}
