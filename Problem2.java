// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

// 1st Approach - Convert the LL to a list and use two pointers to construct the LL
// 2nd Approach -
// 1. Find the Middle of the LL
// 2. Reverse the 2nd half of the LL
// 3. Merge the LL to construct the answer LL


public class Problem2 {


    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode reversedList = reverseList(slow.next);
        slow.next = null;

        ListNode h1 = head;
        ListNode h2 = reversedList;

        while (h2 != null) {
            ListNode temp1 = h1.next;
            h1.next = h2;
            h2 = h2.next;
            h1.next.next = temp1;
            h1 = temp1;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = curr;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
