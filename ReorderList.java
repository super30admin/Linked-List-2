//Time Complexity: O(n)
//Space Complexity: O(1)
//Approach: Since we want the head to look like n0 -> n -> n1 -> n-1 -> n2 (1 -> 5 -> 2 -> 4 -> 3)
//The pattern is that the elements after the middle (3) are in the reversed order and then merged back to the list
//we will find the middle, reverse the next set of elements after middle and then merge back the two lists (until middle and reversed after middle)
public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        //3 parts approach:

        //find the median
        slow = median(slow, fast);
        fast = slow.next;
        slow.next = null;
        slow = head;

        //reverse the second part
        fast = reverse(fast);

        //merge the two lists
        mergeLists(slow, fast);
    }

    private ListNode median(ListNode slow, ListNode fast) {
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode fast) {
        ListNode prev = null, current = fast;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

    private void mergeLists(ListNode slow, ListNode fast) {
        while (fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    public static void main(String[] args) {
        final ReorderList reorderList = new ReorderList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));

        reorderList.reorderList(head);

        assert head.val == 1;
        assert head.next.val == 7;
        assert head.next.next.val == 2;
        assert head.next.next.next.val == 6;
        assert head.next.next.next.next.val == 3;
        assert head.next.next.next.next.next.val == 5;
        assert head.next.next.next.next.next.next.val == 4;
        assert head.next.next.next.next.next.next.next == null;

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        reorderList.reorderList(head);

        assert head.val == 1;
        assert head.next.val == 6;
        assert head.next.next.val == 2;
        assert head.next.next.next.val == 5;
        assert head.next.next.next.next.val == 3;
        assert head.next.next.next.next.next.val == 4;
        assert head.next.next.next.next.next.next == null;
    }
}
