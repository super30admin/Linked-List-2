// https://leetcode.com/problems/reorder-list/
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
class Solution {
    public void reorderList(ListNode head) {
        ListNode temp = head;
        Deque<ListNode> q = new LinkedList<>();
        while (head != null) {
            q.addLast(head);
            head = head.next;
        }

        ListNode prev = null;
        while (!q.isEmpty()) {
            ListNode front = q.pollFirst();
            ListNode back = null;

            if (prev != null)
                prev.next = front;

            if (!q.isEmpty())
                back = q.pollLast();

            front.next = back;
            prev = back;
        }
        if (prev != null)
            prev.next = null;
    }
}