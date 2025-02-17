
// Time Complexity : O(n) where n is the length of the linked list
// Space Complexity : O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// 1. Find the mid of the linked list
// 2. Reverse the linked list from mid.next
// 3. Merge the two linked lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReorderList {
    public void reorderList(ListNode head) {
        // find the mid
        ListNode dummy = new ListNode(-1);
        // dummy for even and odd cases
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // or do like this to handle even or odd cases to stop at one step ahead
        // while(fast.next != null && fast.next.next != null){
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }

        // reverse from slow next
        fast = reverse(slow.next);

        slow.next = null;
        // merge two lists

        slow = head;

        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
