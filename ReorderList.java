// Time Complexity: O(length of original LL)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Idea:
//      1. Find midpoint of LL using slow and fast pointer
//      2. Reverse 2nd half of linked list
//      3. Merge both the linked list


public class ReorderList {
    // Time Complexity: O(length of original LL)
    // Space Complexity: O(1)
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        // find mid using slow and fast pointer
        while(fast.next != null && fast.next.next != null){
            // move
            slow = slow.next;
            fast = fast.next.next;
        }
        // now slow is at mid
        // reverse the other half of linked list
        fast = reverse(slow.next);
        // to cut the connection
        slow.next = null;

        // reset slow
        slow = head;

        ListNode temp;

        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }
    // 1 -> 2 -> 3 -> 4 -> 5
    private ListNode reverse(ListNode node){
        ListNode temp = node.next;
        node.next = null; // reset connection
        ListNode temp2;
        while(temp != null){
            temp2 = temp.next;
            temp.next = node;
            node = temp;
            temp = temp2;
        }
        return node;
    }
}