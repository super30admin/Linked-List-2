// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We split the linked list by identifying the middle node
We then reverse the second half of the list and make the last node of first half to null
we then traverse and merge the two linked lists in the order expected
*/
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //logic to get the middle element 
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the secong half of list
        ListNode reverseHead = reverse(slow.next);
        slow.next = null;
        slow = head;
        fast = reverseHead;
        //re-order the list
        while(fast!=null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow=temp;
        }
    }

    //reverse the linked list
    private ListNode reverse(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
