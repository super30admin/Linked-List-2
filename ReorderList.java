// Time Complexity : O(N) (Find the middlepoint) + O(N) (reverse) + O(N) (Merge the two list) = O(3N) = O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {

    private ListNode reverse(ListNode root) {

        if (root == null || root.next == null) return root;

        ListNode prev = null;
        ListNode curr = root;

        while (curr != null) {

            ListNode temp = curr.next;
            curr.next = prev;

            // Move
            prev = curr;
            curr = temp;

        }

        return prev;
    }

    private void merge(ListNode h1, ListNode h2) {

        while (h1 != null && h2 != null) {

            ListNode temp1 = h1.next;
            ListNode temp2 = h2.next;

            h1.next = h2;
            h2.next = temp1;

            // Move
            h1 = temp1;
            h2 = temp2;

        }

    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        // Find the midpoint
        // It should be first middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow is standing at the midpoint
        // Reverse the LL from slow.next
        ListNode h2 = reverse(slow.next);

        // Break the relation
        slow.next = null;

        ListNode h1 = head;

        // merge h1 and h2
        System.out.println(h1.val);
        System.out.println(h2.val);

        merge(h1, h2);

    }
}