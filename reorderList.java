// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
        {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow.next);
        slow.next = null;
        ListNode p1,p2;

        while(head2!=null)
        {
            p1 = head.next;
            p2 = head2.next;
            head.next = head2;
            head2.next = p1;
            head = p1;
            head2 = p2;
        }
    }

    private ListNode reverse(ListNode node)
    {
        if(node == null || node.next == null)
        {
            return node;
        }
        ListNode temp = null;
        ListNode p1 = node;
        ListNode p2 = node.next;
        node.next = null;

        while(p2!=null)
        {
            temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        return p1;
    }
}
