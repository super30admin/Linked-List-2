// Time Complexity : O(n) where n is the length of the linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// We are given a linked list and we have to reorder it in a specific way.
// We will first find the middle of the linked list using slow and fast pointers.
// Then we will reverse the second half of the linked list.
// Finally, we will merge the two halves of the linked list in the required order.
class Solution {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find middle of linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode midHead = slow.next;
        slow.next = null;

        ListNode prev = null;

        while (midHead != null) {

            ListNode next = midHead.next;

            midHead.next = prev;

            prev = midHead;
            midHead = next;
        }

        ListNode secondHead = prev;
        ListNode firstHead = head;


        // Step 3: Merge two halves
        while (secondHead != null) {

            ListNode temp1 = firstHead.next;
            ListNode temp2 = secondHead.next;

            firstHead.next = secondHead;
            secondHead.next = temp1;

            firstHead = temp1;
            secondHead = temp2;
        }
    }
}