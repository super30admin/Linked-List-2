// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * We break the list from middle. We reverse the second list so that we can start creating the list where list1->node1 points to list2->node1 and list2->node1 points to list1->node2
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow.next;
        slow.next = null;

        fast = reverse(middle);
        slow = head;

        while(fast != null) {
            ListNode tempSlow = slow.next;
            slow.next = fast;
            ListNode tempFast = fast.next;
            fast.next = tempSlow;
            fast = tempFast;
            slow = tempSlow;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}