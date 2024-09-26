// Time Complexity: O(n)
// Space COmplexit: O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow.next);
        slow.next = null;

        ListNode head1 = head;

        while(head1 != null && head2 != null) {
            ListNode temp1= head1.next;
            ListNode temp2 = head2.next;

            head1.next = head2;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }


    }

    private ListNode reverse(ListNode root) {
        ListNode prev = null;

        while(root!= null){
            ListNode temp = root.next;
            root.next = prev;
            prev = root;
            root = temp;
        }
        return prev;
    }
}