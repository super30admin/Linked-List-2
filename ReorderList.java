// TC - O(n)
// SC - O(1)

public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class Solution {
        public void reorderList(ListNode head) {
            if ( head == null || head.next == null) return;

            // mid

            ListNode slow = head;
            ListNode fast = head;
            while(fast.next != null  && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // reverse
            fast = reverseList(slow.next);
            slow.next = null;
            slow = head;

            // merging

            while(fast!=null) {
                ListNode temp =  slow.next;
                slow.next = fast;
                fast = fast.next;
                slow.next.next = temp;
                slow = temp;
            }

        }

        private ListNode reverseList(ListNode head) {

            ListNode prev = null;
            ListNode curr = head;
            ListNode next = null;

            while(curr!=null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
}
