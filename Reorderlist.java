class Solution {

    //O(1) space complexity
    //O(n) time complexity, n is number of nodes 
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        ListNode prev = null;
        slow.next = null;
        while (fast!= null) {
            ListNode next = fast.next;
            fast.next = prev;
            prev = fast;
            fast = next;
        }

        fast = prev;
        ListNode next;
        while (head != null && fast != null) {
            next = head.next;
            head.next = fast;
            fast = fast.next;
            (head.next).next = next;
            head = next;
        }
    }
}