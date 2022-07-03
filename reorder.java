// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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

class Main {
    public static void reorderList(ListNode head) {
        // null case and one size list
        if (head.next == null && head == null)
            return;

        // slow pointer and fast pointer
        ListNode slow = head;
        ListNode fast = head;
        // fast pointer will move two steps whil slow pointer will move one step for
        // getting mid element
        // here I am checking fast.next and fast.next.next as there may be odd number of
        // element or even number of element
        while (fast.next != null && fast.next.next != null) { // O(n)
            slow = slow.next;
            fast = fast.next.next;
        }
        // second half
        ListNode sHead = slow.next;
        // break the second half;
        slow.next = null;
        // reverse the second half
        fast = reverse(sHead); // O(n)
        slow = head;
        // reorder
        while (fast != null) {
            ListNode dummy = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = dummy;
            slow = dummy;
        }

    }

    private static ListNode reverse(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode dummy = head;
            head = head.next;
            dummy.next = result;
            result = dummy;
        }
        return result;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reorderList(head);
        System.out.println(head.next.next.val);
    }
}