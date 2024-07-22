/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast= fast.next.next;
        }

        ListNode midNext = slow.next;
        slow.next = null;
        ListNode previous = null;

        while(midNext != null) {
            ListNode temp = midNext.next;
            midNext.next = previous;
            previous = midNext;
            midNext = temp;
        }

        slow = head;
        midNext = previous;
        while(midNext != null) {
            ListNode slowNext = slow.next;
            ListNode midNodeNext = midNext.next;
            slow.next = midNext;
            midNext.next = slowNext;
            slow = slowNext;
            midNext = midNodeNext;
        }

    }
}