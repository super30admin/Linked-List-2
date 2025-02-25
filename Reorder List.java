class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseList(slow.next);
        slow.next = null; 

        ListNode firstHalf = head;
        mergeLists(firstHalf, secondHalf);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    private void mergeLists(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode temp1 = l1.next, temp2 = l2.next;
            l1.next = l2;
            if (temp1 == null) break;
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }
}

/*
Time Complexity: O(n)
- Finding the middle takes O(n)
- Reversing the second half takes O(n)
- Merging takes O(n)
- Overall: O(n)

Space Complexity: O(1)
- No extra space used, only modifying pointers in-place.
*/
