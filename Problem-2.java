// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// First we find mid using slow and fast pointer
// then reverse the list from mid to end
// finally merge list1 (first half list) and list2 (reveresed list) one by one node from each list
class ReOrderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // find mid
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse and get list2's head
        ListNode headB = reverse(slow.next);
        slow.next = null;
        ListNode headA = head;

        while (headB != null) { // since listB length can be less than or equall to listA length
            ListNode temp = headA.next;
            headA.next = headB;
            headB = headB.next;
            headA.next.next = temp;
            headA = temp;
        }

    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while (fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }

        curr.next = prev;
        return curr;
    }
}